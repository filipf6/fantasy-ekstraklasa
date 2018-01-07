import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RestService} from "../../utils/rest.service";
import {Team} from "../../models/team.model";
import {TeamPlayer} from "../../models/team-player.model";
import {AccuratePosition} from "../../models/enums/accurate-position.enum";

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

  addPlayerToFirstSquad(teamPlayerId, accuratePosition: AccuratePosition): Observable<any> {
    return this.restService.patch(`playerTeams/${teamPlayerId}/addPlayerToFirstSquad`, accuratePosition);
  }

  removePlayerFromFirstSquad(teamPlayerId): Observable<any> {
    return this.restService.patch(`playerTeams/${teamPlayerId}/removePlayerFromFirstSquad`, null);
  }

  substitutePlayers(playerInId, playerOutId): Observable<any> {
    return this.restService.patch(`playerTeams/${playerInId}/${playerOutId}/substitutePlayers`, null);
  }
}

