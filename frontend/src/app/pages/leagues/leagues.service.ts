import { Injectable } from '@angular/core';
import {League} from "../../models/league.model";
import {Observable} from "rxjs/Observable";

@Injectable()
export class LeaguesService {

  static id = 2;
  static mockLeagues: Array<League> = new Array<League>();


  constructor() {
    this.addLeague(new League("Bundesliga"));
    this.addLeague(new League("Premier League"));
  }

  public getLeagues() : Observable<Array<League>> {
    return Observable.of(LeaguesService.mockLeagues);
  }

  public addLeague(league: League) {
    league.id = ++LeaguesService.id;
    LeaguesService.mockLeagues.push(league);
    console.log(LeaguesService.mockLeagues);
  }

}
