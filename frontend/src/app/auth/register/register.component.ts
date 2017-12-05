import { Component, OnInit } from '@angular/core';
import {User} from "../../model/user.model";
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

  constructor(private authenticationService: AuthenticationService, private modalService: NgbModal) {
    this.user=new User();
  }

  register() {
    console.log(this.user);
    this.authenticationService.register(this.user)
      .subscribe(response => {
        console.log(response.status);
        this.modalService.open(SuccessModalComponent,{size:'sm', container:'nb-layout'});
      },error => {
        this.error = "User with this email already exists";
        //console.log(error);
      })
  }

}
