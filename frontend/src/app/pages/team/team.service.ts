import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RestService} from "../../utils/rest.service";
import {Team} from "../../models/team.model";
import {TeamPlayer} from "../../models/team-player.model";

@Injectable()
export class TeamService {

  constructor(private restService: RestService) {
  }

  getPlayers(teamId: number): Observable<TeamPlayer[]> {
    return this.restService.get(`teams/${teamId}/players`);
  }

  getTeam(): Observable<Team> {
    return this.restService.get(`users/team`);
  }

  setTeam(team: Team): Observable<Team> {
    return this.restService.post(`teams/saveTeam`, team);
  }
}
