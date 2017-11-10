import {RouterModule, Routes} from "@angular/router";
import {PagesComponent} from "./pages.component";
import {TeamComponent} from "./team/team.component";
import {NgModule} from "@angular/core";
import {UserComponent} from "./user/user.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'home',
      component: HomeComponent,
    },
    {
      path: 'team',
      component: TeamComponent,
    },
    {
      path: 'user',
      component: UserComponent,
    },
    {
      path: '',
      redirectTo: 'home',
      pathMatch: 'full',
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
