import { Component } from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-league-creation-model',
  templateUrl: './league-creation-model.component.html',
  styleUrls: ['./league-creation-model.component.css']
})
export class LeagueCreationModelComponent {

  modalHeader = `Stwórz ligę`;
  leagueName: string;

  constructor(private activeModal: NgbActiveModal) { }

  closeModal() {
    this.activeModal.close();
  }

  createLeague() {
    this.activeModal.close(this.leagueName);
  }

}
