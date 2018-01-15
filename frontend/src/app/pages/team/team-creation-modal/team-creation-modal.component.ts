import {Component} from "@angular/core";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {TeamService} from "../team.service";

@Component({
  selector: 'success-modal',
  template: `
    <div class="modal-header">
      <h5 class="text-success">{{ modalHeader }}</h5>
      <button class="close" aria-label="Close" (click)="closeModal()">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="modal-body">
      <input [(ngModel)]="teamName" name="name" type="text" placeholder="Nazwa zespołu" class="form-control" required="true" #name="ngModel" [class.form-control-danger]="name.invalid && name.touched"/>
      <small class="form-text error" *ngIf="name.invalid && name.touched">
        Wprowadź nazwę zespołu!
      </small>
    </div>
    <div class="modal-footer">
      <button [disabled]="!name.valid" class="btn btn-hero-primary btn-demo" (click)="setTeam()">Załóż drużynę</button>
    </div>
  `,
})
export class TeamCreationModalComponent {

  modalHeader = `Stwórz swój zespół`;
  teamName: string;

  constructor(private activeModal: NgbActiveModal, private teamService: TeamService) { }

  setTeam() {
    console.log("Tworzę zespół");
    //this.teamService.setTeam(new Team(this.teamName));
    this.activeModal.close(this.teamName);
  }

  closeModal() {
    this.activeModal.close();
  }
}
