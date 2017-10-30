import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';

import { TeamComponent } from './team.component';
import { routing } from './team.routing';
import {TeamService} from "./team.service";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    routing
  ],
  declarations: [
    TeamComponent
  ]
})
export class TeamModule {}
