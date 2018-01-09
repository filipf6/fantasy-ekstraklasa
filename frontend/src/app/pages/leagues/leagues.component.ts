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

  settings = {
    actions: false,
    // add: false,
    // edit:false,
    // delete: false,
    columns: {
      id: {
        title: 'ID',
        type: 'number',
      },
      user: {
        title: 'Użytkownik',
        type: 'string',
      },
      team: {
        title: 'Zespół',
        type: 'string',
      },
      points: {
        title: 'Punkty',
        type: 'number',
      },
    },
  };

  source = [
    {
      id: 1,
      team: 'Orzeł',
      user: 'Andrzej',
      points: '1000'
    },
    {
      id: 2,
      team: 'Fc Dupelona',
      user: 'Mirek',
      points: '720'
    },
    {
      id: 3,
      team: 'RKS',
      user: 'Kuba',
      points: '654'
    },
    {
      id: 4,
      team: 'Orzeł Nielot',
      user: 'KamcioXD',
      points: '421'
    },{
      id: 5,
      team: 'FC Kupa',
      user: 'Kuoa',
      points: '111'
    }
  ];


  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
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

