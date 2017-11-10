import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from './auth.service';

@Injectable()
export class CanActivateAuthGuard implements CanActivate {

  constructor(private router: Router, private authService: AuthenticationService) {}


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('czy zalogowany? '+this.authService.isLoggedIn());
    if (this.authService.isLoggedIn()) {
      // logged in so return true
      return true;
    }

    // not logged in so redirect to login page with the return url and return false
    this.router.navigate(['auth/login']);
    return false;
  }
}