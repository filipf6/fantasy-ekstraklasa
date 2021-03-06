import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NbThemeModule} from '@nebular/theme';

import {AppComponent} from './app.component';
import {HttpModule} from "@angular/http";
import {APP_BASE_HREF} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppRoutingModule} from "./app-routing.module";
import {CoreModule} from "./@core/core.module";
import {AuthenticationService} from "./auth/auth.service";
import {CanActivateAuthGuard} from "./auth/can-activate.authguard";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    AppRoutingModule,

    NgbModule.forRoot(),
    CoreModule.forRoot(),
    NbThemeModule.forRoot({name: 'cosmic'}),
  ],
  providers: [{provide: APP_BASE_HREF, useValue: '/'}, AuthenticationService, CanActivateAuthGuard ],

  bootstrap: [AppComponent],
})
export class AppModule {
}
