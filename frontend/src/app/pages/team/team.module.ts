import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {TeamComponent} from './team.component';
import {routing} from './team.routing';
import {ThemeModule} from "../../@theme/theme.module";
import {TeamCreationModalComponent} from "./team-creation-modal/team-creation-modal.component";
import {PlayerPositionFilterPipe} from "./team-pipes/player-position-filter.pipe";
import {FirstSquadFilterPipe} from "./team-pipes/first-squad-filter.pipe";
import {PlayerComponent} from "./player/player.component";
import {AlreadyInSquadModalComponent} from "./buy-player-failure-modals/already-in-squad-modal.component";
import {TooLowBudgetModalComponent} from "./buy-player-failure-modals/too-low-budget-modal.component";


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
    PlayerPositionFilterPipe,
    FirstSquadFilterPipe,
    PlayerComponent,
    AlreadyInSquadModalComponent,
    TooLowBudgetModalComponent
  ],
  entryComponents: [TeamCreationModalComponent, AlreadyInSquadModalComponent, TooLowBudgetModalComponent],
})
export class TeamModule {
}
