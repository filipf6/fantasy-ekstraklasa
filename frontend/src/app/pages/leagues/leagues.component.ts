import {Component, OnInit} from '@angular/core';
import {LeaguesService} from "./leagues.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {LeagueCreationModelComponent} from "./league-creation-model/league-creation-model.component";
import {League} from "../../models/league.model";

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {

  constructor(private leagueService: LeaguesService, private modalService: NgbModal) {
  }

  ngOnInit() {
  }

  openLeagueCreationModal() {
    this.modalService
    .open(LeagueCreationModelComponent, {size: 'sm', container: 'nb-layout'})
    .result
    .then(leagueName => this.leagueService
    .addLeague(new League(leagueName)))
    .catch(reason => console.log(reason));

  }

  doNothing() {

  }

}
