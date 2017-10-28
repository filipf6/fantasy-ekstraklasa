import { Routes, RouterModule } from '@angular/router';

import { TeamComponent } from './team.component';

const routes: Routes = [
  {
    path: '',
    component: TeamComponent
  }
];

export const routing = RouterModule.forChild(routes);
