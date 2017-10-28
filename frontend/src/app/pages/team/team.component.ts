import {Component} from "@angular/core";
import {PlayerPresentation} from "./playerPresentation";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'team-component',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent {
  players: PlayerPresentation[]=[];

  constructor(private http: Http) {

  }

  get(teamId: number) {
    this.getPlayers(teamId).subscribe(data=> {
      this.players = data;
      console.log(this.players);
    });
  }

  getPlayers(teamId: number): Observable<any> {
    return this.http.get(`api/teams/${teamId}/players`).map(response=>response.json());
  }
}
