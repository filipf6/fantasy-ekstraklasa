import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {TeamModule} from './team/team.module';
import {PagesRoutingModule} from './pages.routing';
import {ThemeModule} from "../@theme/theme.module";
import {NbMenuService, NbSidebarService} from "@nebular/theme";
import {NbMenuInternalService} from "@nebular/theme/components/menu/menu.service";
import {UserModule} from "./user/user.module";
import {TeamService} from "./team/team.service";
import {RestService} from "../utils/rest.service";
import {NbAuthService} from "@nebular/auth";
import {HomeModule} from "./home/home.module";
import { GameplayComponent } from './gameplay/gameplay.component';
import { LeaguesComponent } from './leagues/leagues.component';
import {LeagueCreationModelComponent} from "./leagues/league-creation-model/league-creation-model.component";
import {LeaguesService} from "./leagues/leagues.service";

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    HomeModule,
    TeamModule,
    UserModule,
    ThemeModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS,
    GameplayComponent,
    LeaguesComponent,
    LeagueCreationModelComponent
  ],
  providers: [NbMenuService, NbSidebarService, NbMenuInternalService, TeamService, RestService, NbAuthService, LeaguesService],
  entryComponents: [LeagueCreationModelComponent],
})
export class PagesModule {
}
