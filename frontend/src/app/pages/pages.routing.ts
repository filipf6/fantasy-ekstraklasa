import {RouterModule, Routes} from "@angular/router";
import {PagesComponent} from "./pages.component";
import {TeamComponent} from "./team/team.component";
import {NgModule} from "@angular/core";
import {UserComponent} from "./user/user.component";

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [{
    path: 'team',
    component: TeamComponent,
  },
    {
      path: 'user',
      component: UserComponent,
    },
    {
      path: '',
      redirectTo: 'team',
      pathMatch: 'full',
    }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
