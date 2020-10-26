import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterHomeComponent } from './register-home/register-home.component';
import {RegisterRoutingModule} from './register-routing.module';


@NgModule({
  declarations: [RegisterHomeComponent],
  imports: [
    CommonModule, 
    RegisterRoutingModule
  ]
})
export class RegisterModule { }
