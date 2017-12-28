import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {TeamComponent} from './team.component';
import {routing} from './team.routing';
import {ThemeModule} from "../../@theme/theme.module";
import {TeamCreationModalComponent} from "./team-creation-modal/team-creation-modal.component";
import {PlayerPositionFilterPipe} from "./player-position-filter.pipe";


@NgModule({
  imports: [
    ThemeModule,
    CommonModule,
    FormsModule,
    routing
  ],
  declarations: [
    TeamComponent,
    TeamCreationModalComponent,
    PlayerPositionFilterPipe
  ],
  entryComponents: [TeamCreationModalComponent],
})
export class TeamModule {
}
