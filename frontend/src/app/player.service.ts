import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private apiUrl = 'http://localhost:8080/players'; // URL to your backend

  constructor(private http: HttpClient) { }

  getPlayers(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
  getPlayersByPosition(position: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/position/${position}`);
  }
}
