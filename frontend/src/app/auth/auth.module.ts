import {NgModule} from "@angular/core";
import {ThemeModule} from "../@theme/theme.module";
//import {LoginModule} from "./login/login.module";
import {AuthComponent} from "./auth.component";
// import {AuthRoutingModule} from "./auth.routing";
import {NbAuthModule} from "@nebular/auth";
import {AuthenticationService} from "./auth.service";
//import {RegisterModule} from "./register/register.module";
import {RouterModule} from "@angular/router";
import {routing} from "./auth.routing";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {SuccessModalComponent} from "./register/success-modal/success-modal.component";

@NgModule({
  imports: [
    // AuthRoutingModule,
    routing,
    //LoginModule,
   // RegisterModule,
    ThemeModule,
    NbAuthModule,
    RouterModule
  ],
  declarations: [
    AuthComponent,
    LoginComponent,
    RegisterComponent,
    SuccessModalComponent
  ],
  entryComponents: [SuccessModalComponent],
  providers: [AuthenticationService]
})
export class AuthModule {
}
