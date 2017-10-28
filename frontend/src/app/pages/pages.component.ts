import { Component } from '@angular/core';

import { MENU_ITEMS } from './pages.menu';

@Component({
  selector: 'ngx-pages',
  template: `
    <!--<ngx-sample-layout>-->
      <!--<nb-menu [items]="menu"></nb-menu>-->
      <!--<router-outlet></router-outlet>-->
    <!--</ngx-sample-layout>-->
    <nb-layout>
    <nb-layout-header fixed>Company Name</nb-layout-header>

    <nb-sidebar>
      <nb-menu [items]="menu"></nb-menu>
      
    </nb-sidebar>
    <nb-layout-column><router-outlet></router-outlet></nb-layout-column>
    </nb-layout>
  `,
})
export class PagesComponent {

  menu = MENU_ITEMS;
}
