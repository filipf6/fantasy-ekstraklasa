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

  leagueNames: string[]=['liga PK', 'ekstraliga', 'liga deblin'];
  selectedLeague: string;


  constructor(private leagueService: LeaguesService, private modalService: NgbModal) {
    this.leagueNames.forEach(league=>console.log(league));
  }

  ngOnInit() {
  }

  settings = {
    actions: false,
    // add: true,
    // edit:false,
    // delete: false,
    columns: {
      id: {
        title: 'Pozycja',
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

  source1 = [
    {
      id: 1,
      team: 'RKS',
      user: 'filip@onet.pl',
      points: '1022'
    },
    {
      id: 2,
      team: 'FC PK',
      user: 'mirek@onet.pl',
      points: '720'
    },
    {
      id: 3,
      team: 'FC UJ',
      user: 'kuba@onet.pl',
      points: '654'
    },
    {
      id: 4,
      team: 'Orzeł Dębno',
      user: 'kamil@onet.pl',
      points: '421'
    },{
      id: 5,
      team: 'FC AGH',
      user: 'michal@onet.pl',
      points: '111'
    }
  ];
  source2 = [
    {
      id: 1,
      team: 'WKS',
      user: 'mariusz@wp.pl',
      points: '1999'
    },
    {
      id: 2,
      team: 'RKS',
      user: 'filip@onet.pl',
      points: '1022'
    },
    {
      id: 3,
      team: 'FC UJ',
      user: 'kuba@onet.pl',
      points: '654'
    },
    {
      id: 4,
      team: 'TEB Edukacja',
      user: 'teb@onet.pl',
      points: '592'
    },{
      id: 5,
      team: 'FC brancelona',
      user: 'barka@onet.pl',
      points: '290'
    },{
      id: 6,
      team: 'bad team',
      user: 'wojtas@wp.pl',
      points: '180'
    },
    {
      id: 7,
      team: 'FC dreamteam',
      user: 'jurek@wp.pl',
      points: '160'
    }
  ];
  source3 = [
    {
      id: 1,
      team: 'Polonia',
      user: 'damian@wp.pl',
      points: '1500'
    },
    {
      id: 2,
      team: 'Wroclove',
      user: 'michalina@onet.pl',
      points: '1230'
    },
    {
      id: 3,
      team: 'RKS',
      user: 'filip@onet.pl',
      points: '1022'
    },
    {
      id: 4,
      team: 'Orzeł Dębno',
      user: 'kamil@onet.pl',
      points: '421'
    },{
      id: 5,
      team: 'GKS',
      user: 'waclaw@onet.pl',
      points: '241'
    }
  ];
  source4 = [
    {
      id: 1,
      team: 'RKS',
      user: 'filip@onet.pl',
      points: '1022'
    }];


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
      .then(leagueName => this.leagueNames.push(leagueName))
      .catch(reason => console.log(reason));

  }

  doNothing() {

  }

}

