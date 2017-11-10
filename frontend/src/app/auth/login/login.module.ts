import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';

import { LoginComponent } from './login.component';
import {ThemeModule} from "../../@theme/theme.module";
//import { routing } from './login.routing';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ThemeModule
    // routing
  ],
  declarations: [
    LoginComponent
  ]
})
export class LoginModule {}
