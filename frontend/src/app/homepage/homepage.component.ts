import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-homepage',
  standalone: true,
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
  imports: [CommonModule, HttpClientModule],
  providers: [PlayerService]
})
export class HomepageComponent {
  appName: string = "Fantasy Football Draft Guide";
  players: any[] = [];

  // Directly use position abbreviations
  positions: string[] = ['QB', 'RB', 'WR', 'TE', 'K', 'DEF'];
  selectedPosition: string = '';

  constructor(private playerService: PlayerService) { }

  ngOnInit() {
    this.loadPlayers();
  }

  loadPlayers() {
    const position = this.selectedPosition || '';
    if (position) {
      this.playerService.getPlayersByPosition(position).subscribe(data => {
        this.players = data;
      });
    } else {
      this.playerService.getPlayers().subscribe(data => {
        this.players = data;
      });
    }
    console.log(this.players);
  }

  onPositionChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.selectedPosition = selectElement.value;
    console.log('Selected Position:', this.selectedPosition);
    this.loadPlayers();
  }
}
