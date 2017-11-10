import {Component, Input} from '@angular/core';

import {NbMenuService, NbSidebarService} from '@nebular/theme';
import {AnalyticsService} from '../../../@core/utils/analytics.service';
//import {NbAuthJWTToken, NbAuthService} from '@nebular/auth';

@Component({
  selector: 'ngx-header',
  styleUrls: ['./header.component.scss'],
  templateUrl: './header.component.html',
})
export class HeaderComponent {


  @Input() position = 'normal';

  loggedUser: any;

  userMenu = [{title: 'Profile'}, {title: 'Log out'}];

  constructor(private sidebarService: NbSidebarService,
              private menuService: NbMenuService,
              private analyticsService: AnalyticsService){//,
              //private authService: NbAuthService) {
    // this.authService.onTokenChange()
    //   .subscribe((token: NbAuthJWTToken) => {
    //
    //     if (token.getValue()) {
    //       this.user = token.getPayload(); // here we receive a payload from the token and assigne it to our `user` variable
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

  toggleSettings(): boolean {
    this.sidebarService.toggle(false, 'settings-sidebar');
    return false;
  }

  goToHome() {
    this.menuService.navigateHome();
  }

  startSearch() {
    this.analyticsService.trackEvent('startSearch');
  }
}
