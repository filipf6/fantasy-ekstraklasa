import {Component} from '@angular/core';

import {MENU_ITEMS} from './pages.menu';
import {NbMenuService, NbSidebarService} from "@nebular/theme";
import {NbAuthJWTToken, NbAuthService, NbTokenService} from '@nebular/auth';


@Component({
  selector: 'ngx-pages',
  template: `

    <nb-layout windowMode>

      <nb-layout-header fixed>
        <ngx-header>
          <!--<div class="header-container left">-->
            <!--<a (click)="toggleSidebar()" href="#" class="navigation"><i class="fa fa-bars fa-3x"></i></a>-->
          <!--</div>-->
          <!--<nb-actions class="header-container">-->
            <!--<nb-action>-->
              <!--<nb-user [name]="loggedUser" [picture]="user?.picture"></nb-user>-->
            <!--</nb-action>-->
          <!--</nb-actions>-->
        </ngx-header>
      </nb-layout-header>


      <nb-sidebar responsive>
        <nb-menu [items]="menu"></nb-menu>

      </nb-sidebar>
      <nb-layout-column>
        <router-outlet></router-outlet>
      </nb-layout-column>
    </nb-layout>
  `,
})
export class PagesComponent {
  menu = MENU_ITEMS;
  loggedUser: any;

  constructor(private sidebarService: NbSidebarService,
              private menuService: NbMenuService,
              private authService: NbAuthService,
              private tokenService: NbTokenService) {
    // this.tokenService.tokenChange()
    //   .subscribe(token=>console.log('TOKEN: '+token.getValue()));
    //
    //
    // this.authService.onTokenChange()
    //   .subscribe((token: NbAuthJWTToken) => {
    //     console.log(token);
    //     console.log('TOKEN: '+token.getValue());
    //     this.authService.isAuthenticated().subscribe(is=>console.log('isauth; '+is));
    //
    //
    //     console.log(JSON.stringify({token: token}));
    //     if (token.getValue()) {
    //       this.user = token.getPayload(); // here we receive a payload from the token and assigne it to our `user` variable
    //       // console.log(token.getPayload());
    //     }
    //
    //   });
    this.loggedUser = localStorage.getItem('currentUser') ?
      JSON.parse(localStorage.getItem('currentUser')).email :
      'none user logged in';
  }

  toggleSidebar(): boolean {
    this.sidebarService.toggle(true, 'menu-sidebar');
    return false;
  }
}
