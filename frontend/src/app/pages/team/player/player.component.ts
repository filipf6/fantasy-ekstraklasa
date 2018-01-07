import {Component, EventEmitter, Input, Output} from "@angular/core";
import {TeamPlayer} from "../../../models/team-player.model";
import {AccuratePosition} from "../../../models/enums/accurate-position.enum";


@Component({
  selector: 'player-component',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent {
  @Input() teamPlayer: TeamPlayer;
  @Input() accuratePosition: AccuratePosition;
  @Output() removePlayer: EventEmitter<any> = new EventEmitter();
  @Output() addPlayer: EventEmitter<any> = new EventEmitter();
  @Output() substitutePlayer: EventEmitter<any> = new EventEmitter();

  removePlayerFromFirstSquad() {
    this.removePlayer.emit(this.teamPlayer.id);
  }

  addPlayerToFirstSquad() {
    this.addPlayer.emit(this.accuratePosition);
  }

  substitutePlayers() {
    this.substitutePlayer.emit(this.teamPlayer);
  }

  getPlayerClass() {
    switch(this.accuratePosition){
      case AccuratePosition.GK: return 'player-goalkeeper';
      case AccuratePosition.RB: return 'player-right-defender';
      case AccuratePosition.CRB: return 'player-center-right-defender';
      case AccuratePosition.CLB: return 'player-center-left-defender';
      case AccuratePosition.LB: return 'player-left-defender';
      case AccuratePosition.RM: return 'player-right-midfielder';
      case AccuratePosition.CRM: return 'player-center-right-midfielder';
      case AccuratePosition.CLM: return 'player-center-left-midfielder';
      case AccuratePosition.LM: return 'player-left-midfielder';
      case AccuratePosition.RS: return 'player-right-forward';
      case AccuratePosition.LS: return 'player-left-forward';
    }
  }

}
