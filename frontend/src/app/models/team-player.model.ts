import {Player} from "./player.model";

export class TeamPlayer {
  id: number;
  player: Player;
  firstSquad: boolean;
  captain: boolean;
  viceCaptain: boolean;
  accuratePosition: string;

  constructor(accuratePosition: string) {
    this.accuratePosition = accuratePosition;
  }
}

