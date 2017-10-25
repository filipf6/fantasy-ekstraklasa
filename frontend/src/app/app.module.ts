import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NbThemeModule, NbSidebarModule, NbLayoutModule, NbSidebarService } from '@nebular/theme';

import { AppComponent } from './app.component';
import {HttpModule} from "@angular/http";
// import {RestService} from "./rest.service";
// import {TeamsService} from "./teams.service";
// import {Http, HttpModule} from "@angular/http";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    NbThemeModule.forRoot({ name: 'cosmic' }),
    NbLayoutModule,
    NbSidebarModule,
    HttpModule,
  ],
  providers: [NbSidebarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
