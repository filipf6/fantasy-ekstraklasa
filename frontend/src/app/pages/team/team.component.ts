import {Component} from "@angular/core";
import {PlayerPresentation} from "./player.presentation";
import {TeamService} from "./team.service";

@Component({
  selector: 'team-component',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent {
  players: PlayerPresentation[] = [];

  constructor(private teamService: TeamService) {
  }

  getPlayers(teamId: number) {
    return this.teamService.getPlayers(teamId).subscribe(data => this.players = data);
  }
}
