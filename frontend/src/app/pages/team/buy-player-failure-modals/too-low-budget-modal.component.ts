import {Component} from "@angular/core";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'already-in-squad-modal',
  template: `
    <div class="modal-header">
      <h5 style="color: indianred">{{ modalHeader }}</h5>
      <button class="close" aria-label="Close" (click)="closeModal()">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="modal-body">
      Budżet twojej drużyny jest niewystarczający!
    </div>
  `,
})
export class TooLowBudgetModalComponent {

  modalHeader = `Nie możesz kupić tego zawodnika`;

  constructor(private activeModal: NgbActiveModal) { }

  closeModal() {
    this.activeModal.close();
  }
}
