import {Component, OnInit} from '@angular/core';
import {User} from "../../models/user.model";
import {AuthenticationService} from "../auth.service";
import {Router} from "@angular/router";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {SuccessModalComponent} from "./success-modal/success-modal.component";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  //errors: string[] = [];
  error: string;
  user: User;
  submitted: boolean = false;

  constructor(private authenticationService: AuthenticationService, private modalService: NgbModal) {
    this.user = new User();
  }

  register() {
    this.submitted = true;
    this.authenticationService.register(this.user)
      .subscribe(response => {
        this.submitted = false;
        this.modalService.open(SuccessModalComponent, {size: 'sm', container: 'nb-layout'});
      }, error => {
        this.submitted = false;
        this.error = "Użytkownik o podanym adresie e-mail już istnieje";
      })
  }

}
