import {Component} from "@angular/core";
import {TeamService} from "./team.service";
import {Team} from "../../models/team.model";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {TeamCreationModalComponent} from "./team-creation-modal/team-creation-modal.component";
import {TeamPlayer} from "../../models/team-player.model";
import {accuratePositions} from "../../models/global";
import {AccuratePosition} from "../../models/enums/accurate-position.enum";

@Component({
  selector: 'team-component',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent {
  teamPlayers: TeamPlayer[] = [];
  team: Team;
  firstSquadPlayers: TeamPlayer[] = [];
  addIconsHidden: boolean[] = [true, true, true, true];
  substitutionIconsHidden: boolean[] = [true, true, true, true];
  tempAccuratePosition: AccuratePosition;
  tempPlayerOut: TeamPlayer;

  constructor(private teamService: TeamService, private modalService: NgbModal) {
    this.getTeam();
  }

  get accuratePositions() {
    return accuratePositions;
  }

  removePlayerFromFirstSquad(teamPlayerId) {
    this.teamService.removePlayerFromFirstSquad(teamPlayerId).subscribe(data => {
      console.log('player removed: ' + data);
      this.getPlayers(this.team.id);
    }, error => console.log('removePlayer error'));
  }

  addPlayerToFirstSquad(teamPlayerId, accuratePosition) {
    this.teamService.addPlayerToFirstSquad(teamPlayerId, accuratePosition)
      .subscribe(data => {
      this.getPlayers(this.team.id);
    }, error => console.log('addPlayer error: ' + error));
  }

  selectPlayerToAdd(accuratePosition: AccuratePosition) {
    this.tempAccuratePosition = accuratePosition;
    switch (accuratePosition) {
      case AccuratePosition.GK:
        this.addIconsHidden[0] = false;
        this.addIconsHidden[1] = true;
        this.addIconsHidden[2] = true;
        this.addIconsHidden[3] = true;
        break;
      case AccuratePosition.RB:
      case AccuratePosition.CRB:
      case AccuratePosition.CLB:
      case AccuratePosition.LB:
        this.addIconsHidden[1] = false;
        this.addIconsHidden[0] = true;
        this.addIconsHidden[2] = true;
        this.addIconsHidden[3] = true;
        break;
      case AccuratePosition.RM:
      case AccuratePosition.CRM:
      case AccuratePosition.CLM:
      case AccuratePosition.LM:
        this.addIconsHidden[2] = false;
        this.addIconsHidden[0] = true;
        this.addIconsHidden[1] = true;
        this.addIconsHidden[3] = true;
        break;
      case AccuratePosition.RS:
      case AccuratePosition.LS:
        this.addIconsHidden[3] = false;
        this.addIconsHidden[0] = true;
        this.addIconsHidden[1] = true;
        this.addIconsHidden[2] = true;
        break;
    }
  }

  selectPlayerToSubstituteIn(teamPlayerOut: TeamPlayer) {
    this.tempPlayerOut = teamPlayerOut;
    switch (teamPlayerOut.accuratePosition) {
      case AccuratePosition.GK:
        this.substitutionIconsHidden[0] = false;
        this.substitutionIconsHidden[1] = true;
        this.substitutionIconsHidden[2] = true;
        this.substitutionIconsHidden[3] = true;
        break;
      case AccuratePosition.RB:
      case AccuratePosition.CRB:
      case AccuratePosition.CLB:
      case AccuratePosition.LB:
        this.substitutionIconsHidden[1] = false;
        this.substitutionIconsHidden[0] = true;
        this.substitutionIconsHidden[2] = true;
        this.substitutionIconsHidden[3] = true;
        break;
      case AccuratePosition.RM:
      case AccuratePosition.CRM:
      case AccuratePosition.CLM:
      case AccuratePosition.LM:
        this.substitutionIconsHidden[2] = false;
        this.substitutionIconsHidden[0] = true;
        this.substitutionIconsHidden[1] = true;
        this.substitutionIconsHidden[3] = true;
        break;
      case AccuratePosition.RS:
      case AccuratePosition.LS:
        this.substitutionIconsHidden[3] = false;
        this.substitutionIconsHidden[0] = true;
        this.substitutionIconsHidden[1] = true;
        this.substitutionIconsHidden[2] = true;
        break;
    }
  }

  substitutePlayers(teamPlayerInId: number) {
    this.teamService.substitutePlayers(teamPlayerInId, this.tempPlayerOut.id).subscribe(data => {
      console.log('player added: ' + data);
      this.getPlayers(this.team.id);
    }, error => console.log('addPlayer error'));
  }

  getTeam() {
    this.teamService.getTeam().subscribe(data => {
      this.team = data;
      if (this.team) this.getPlayers(this.team.id);
    }, error => console.log('getTeam error: '+error));
  }

  getPlayers(teamId: number) {
    for (let i = 0; i < 4; i++) {
      this.addIconsHidden[i] = true;
    }
    this.addIconsHidden.forEach(hidden => console.log(hidden));
    this.teamService.getPlayers(teamId).subscribe(data => {
      this.teamPlayers = data;
      for (let i = 0; i < 11; i++) {
        this.firstSquadPlayers[i] = this.teamPlayers.find(player => player.firstSquad && player.accuratePosition === accuratePositions[i]);
      }
      this.firstSquadPlayers.forEach(p => console.log(p));
    }, error => console.log('getPlayers error'));
  }

  openTeamCreationModal() {
    this.modalService
      .open(TeamCreationModalComponent, {size: 'sm', container: 'nb-layout'})
      .result
      .then(teamName => this.teamService
        .setTeam(new Team(teamName))
        .subscribe(savedTeam => this.team = savedTeam))
      .catch();
  }


}
