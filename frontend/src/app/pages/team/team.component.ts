import {Component} from "@angular/core";
import {TeamService} from "./team.service";
import {Team} from "../../models/team.model";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {TeamCreationModalComponent} from "./team-creation-modal/team-creation-modal.component";
import {Player} from "../../models/player.model";

@Component({
  selector: 'team-component',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent {
  players: Player[] = [];
  team: Team;


  constructor(private teamService: TeamService, private modalService: NgbModal) {
    this.getTeam();

  }

  getTeam() {
    this.teamService.getTeam().subscribe(data => {
      console.log('data: '+data);
      this.team = data;
      console.log(this.team);
      if(this.team) this.getPlayers(this.team.id);
    });
  }

  getPlayers(teamId: number) {
      return this.teamService.getPlayers(teamId).subscribe(data => this.players = data, error => console.log('getPlayers error'));
  }

  openTeamCreationModal() {
      this.modalService
      .open(TeamCreationModalComponent, {size: 'sm', container: 'nb-layout'})
      .result
        .then(teamName=> this.teamService
          .setTeam(new Team(teamName))
          .subscribe(savedTeam => this.team = savedTeam))
        .catch();
  }


}
