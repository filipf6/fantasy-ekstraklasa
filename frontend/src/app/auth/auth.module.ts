import {NgModule} from "@angular/core";
import {ThemeModule} from "../@theme/theme.module";
import {LoginModule} from "./login/login.module";
import {AuthComponent} from "./auth.component";
import {AuthRoutingModule} from "./auth.routing";
import {NbAuthModule} from "@nebular/auth";
import {AuthenticationService} from "./auth.service";

@NgModule({
  imports: [
    AuthRoutingModule,
    LoginModule,
    ThemeModule,
    NbAuthModule,
  ],
  declarations: [
    AuthComponent,
  ],
  providers: [AuthenticationService]
})
export class AuthModule {
}
