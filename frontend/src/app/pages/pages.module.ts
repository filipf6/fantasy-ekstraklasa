import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { TeamModule } from './team/team.module';
import { PagesRoutingModule } from './pages.routing';
import {ThemeModule} from "../@theme/theme.module";
import {NbMenuService, NbSidebarService} from "@nebular/theme";
import {NbMenuInternalService} from "@nebular/theme/components/menu/menu.service";
import {UserModule} from "./user/user.module";
import {TeamService} from "./team/team.service";
import {RestService} from "../utils/rest.service";

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    TeamModule,
    UserModule,
    ThemeModule
  ],
  declarations: [
    ...PAGES_COMPONENTS,
  ],
  providers: [NbMenuService, NbSidebarService, NbMenuInternalService, TeamService, RestService]
})
export class PagesModule {
}
