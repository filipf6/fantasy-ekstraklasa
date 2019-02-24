import {Component} from "@angular/core";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

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
      <div class="links">
          Twoje konto zostało założone pomyślnie. Możesz się teraz <a routerLink="../login" (click)="closeModal()"><strong>zalogować</strong></a>
      </div>
    </div>
    <div class="modal-footer">
    </div>
  `,
})
export class SuccessModalComponent {

  modalHeader = `Rejestracja zakończona pomyślnie!`;

  constructor(private activeModal: NgbActiveModal) { }

  closeModal() {
    this.activeModal.close();
  }
}
