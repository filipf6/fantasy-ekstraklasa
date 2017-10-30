import {Injectable} from "@angular/core";
import {PlayerPresentation} from "./player.presentation";
import {Observable} from "rxjs/Observable";
import {RestService} from "../../utils/rest.service";

@Injectable()
export class TeamService {

  constructor(private restService: RestService) {}

  getPlayers(teamId: number): Observable<PlayerPresentation[]> {
    return this.restService.get(`teams/${teamId}/players`);
  }
}
