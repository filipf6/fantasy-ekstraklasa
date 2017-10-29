import {Component} from '@angular/core';

import {MENU_ITEMS} from './pages.menu';
import {NbMenuService, NbSidebarService} from "@nebular/theme";

@Component({
  selector: 'ngx-pages',
  template: `

    <nb-layout>
      <nb-layout-header fixed><a (click)="toggleSidebar()" href="#" class="navigation"><i class="fa fa-bars fa-3x"></i></a>
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

  constructor(private sidebarService: NbSidebarService, private menuService: NbMenuService) {
  }

  toggleSidebar(): boolean {
    this.sidebarService.toggle(true, 'menu-sidebar');
    return false;
  }
}
