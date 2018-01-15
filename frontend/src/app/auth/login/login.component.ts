import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {AuthenticationService} from "../auth.service";

@Component({
  selector: 'fe-login',
  styleUrls: ['./login.component.scss'],
  templateUrl: 'login.component.html',
})
export class LoginComponent implements OnInit {

  submitted: boolean = false;
  user: any = {};
  error: string;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  login() {
    this.submitted = true;
    this.authenticationService.login(this.user.email, this.user.password)
      .subscribe(result => {
        if(result===true) this.router.navigate(['pages']);
        else {
          this.error = 'Nazwa użytkownika lub hasło jest nieprawidłowe';
          this.submitted = false;
        }
      }, error => {
        this.submitted = false;
        this.error = 'Nazwa użytkownika lub hasło jest nieprawidłowe';
      })
  }

  ngOnInit() {
    this.authenticationService.logout();

  }

}
