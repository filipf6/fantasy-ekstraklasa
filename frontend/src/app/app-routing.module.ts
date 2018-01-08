import {ExtraOptions, RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {CanActivateAuthGuard} from "./auth/can-activate.authguard";


const routes: Routes = [
  { path: 'pages', loadChildren: 'app/pages/pages.module#PagesModule', canActivate: [CanActivateAuthGuard] },
  { path: 'auth', loadChildren: 'app/auth/auth.module#AuthModule' },
  { path: '', redirectTo: 'pages', pathMatch: 'full' },
  { path: '**', redirectTo: 'pages' },
  ];

const config: ExtraOptions = {
  useHash: true,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
