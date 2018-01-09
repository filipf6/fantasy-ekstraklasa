import {Team} from "./team.model";

export class League {
  id: number;
  name: string;
  teams: Array<Team>

  constructor(name: string) {
    this.name = name;
  }
}
