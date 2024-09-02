import os.path

from dotenv import load_dotenv
import google.auth
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
from google_auth_oauthlib.flow import InstalledAppFlow
import psycopg2
import collections

load_dotenv()
SPREADSHEET_ID = os.getenv('SPREADSHEET_ID')
DBPW = os.getenv('DBPW')
SCOPES = ['https://www.googleapis.com/auth/spreadsheets.readonly']

def load_sheets_api():
    creds = None
    if os.path.exists('token.json'):
        creds = google.oauth2.credentials.Credentials.from_authorized_user_file(
            'token.json', SCOPES)
    if not creds or not creds.valid:
        if creds and creds.expired and creds.refresh_token:
            creds.refresh(google.auth.transport.requests.Request())
        else:
            iaf = InstalledAppFlow
            flow = iaf.from_client_secrets_file('credentials.json', SCOPES)
            creds = flow.run_local_server()
        with open('token.json', 'w') as token:
            token.write(creds.to_json())
    return build('sheets', 'v4', credentials=creds)

def get_player_data(id, sheet_name, range):
    try:
        service = load_sheets_api()

        result = (
            service.spreadsheets()
            .values()
            .get(spreadsheetId=id, range=f'{sheet_name}!{range}')
            .execute()
        )
        rows = result.get('values', [])
        print(f'{len(rows)} rows retrieved')
        return result
    except HttpError as error:
        print(f'An error occurred: {error}')
        return error
    
def get_players():
    players = get_player_data(SPREADSHEET_ID, 'ESPN Standard', 'B2:D225')['values']

    players_dict = []
    for player in players:
        entry= {}
        entry['name'] = player[0]
        entry['team'] = player[1]
        entry['bye'] = player[2]
        players_dict.append(entry)
    return players_dict
    

def get_rankings(format):
    rank_map = {}
    ranking = [player[0] for player in (get_player_data(SPREADSHEET_ID, format, 'B2:B225'))['values']]
    for rank, player in enumerate(ranking):
        rank_map[player] = rank + 1
    return rank_map

if __name__ == "__main__":
    platform_rankings = {
        'espn': {
            'espn_std': get_rankings('ESPN Standard'),
            'espn_half_ppr': get_rankings('ESPN .5PPR'),
            'espn_ppr': get_rankings('ESPN PPR')
        },
        'sleeper': {
            'sleeper_std': get_rankings('Sleeper Standard'),
            'sleeper_half_ppr': get_rankings('Sleeper .5PPR'),
            'sleeper_ppr': get_rankings('Sleeper PPR')
        },
        'yahoo': {
            'yahoo_std': get_rankings('Yahoo Standard'),
            'yahoo_half_ppr': get_rankings('Yahoo .5PPR'),
            'yahoo_ppr': get_rankings('Yahoo PPR')
        }
    }

    try:
        connection = psycopg2.connect(
            database="nfl_fantasy", user='postgres', password=DBPW, host='localhost', port='5432'
        )
        connection.autocommit = True
        cursor = connection.cursor()

        players = get_players()
        players.sort(key=lambda info: info['name'])

        #clean out db
        cursor.execute("DELETE from players")
        for platform in platform_rankings.keys():
            cursor.execute(f"DELETE FROM {platform}")
        
        #create players table
        for player in players:
            cursor.execute(
                f"INSERT INTO players(player_id, name, team, bye) VALUES (DEFAULT, $${player['name']}$$, $${player['team']}$$, $${player['bye']}$$)"
            )

        for player_info in players:
            player = player_info['name']
            for platform, formats in platform_rankings.items():
                std = formats.get(f'{platform}_std', {}).get(player, None)
                half_ppr = formats.get(f'{platform}_half_ppr', {}).get(player, None)
                ppr = formats.get(f'{platform}_ppr', {}).get(player, None)

                cursor.execute(
                    f"INSERT INTO {platform}(player_id, name, standard_rank, half_ppr_rank, ppr_rank) "
                    f"VALUES ((SELECT player_id FROM players WHERE name = $${player}$$), %s, %s, %s, %s)",
                    (player, std, half_ppr, ppr)
                )

    except Exception as e:
        print(f'An error occurred while connecting to the database: {e}')
    finally:
        if connection:
            cursor.close()
            connection.close()
    
