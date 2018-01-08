import {Component} from '@angular/core';

import {MENU_ITEMS} from './pages.menu';
import {NbMenuService, NbSidebarService} from "@nebular/theme";
import {NbAuthService, NbTokenService} from '@nebular/auth';


@Component({
  selector: 'ngx-pages',
  template: `

    <nb-layout windowMode>

      <nb-layout-header fixed>
        <ngx-header>
        </ngx-header>
      </nb-layout-header>


      <nb-sidebar>
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

    this.loggedUser = localStorage.getItem('currentUser') ?
      JSON.parse(localStorage.getItem('currentUser')).email :
      'none user logged in';
  }

  toggleSidebar(): boolean {
    this.sidebarService.toggle(true, 'menu-sidebar');
    return false;
  }
}
