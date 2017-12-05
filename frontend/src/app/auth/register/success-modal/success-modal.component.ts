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
          Your account has been created successfully. You can now <a routerLink="../login" (click)="closeModal()"><strong>Sign in</strong></a>
      </div>
    </div>
    <div class="modal-footer">
    </div>
  `,
})
export class SuccessModalComponent {

  modalHeader = `Register success!`;

  constructor(private activeModal: NgbActiveModal) { }

  closeModal() {
    this.activeModal.close();
  }
}
