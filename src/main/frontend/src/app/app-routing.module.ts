import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginHomeComponent} from './login/login-home/login-home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterHomeComponent } from './register/register-home/register-home.component';

const routes: Routes = [
  {path: 'login', component: LoginHomeComponent},
  {path: 'register', component: RegisterHomeComponent},
  {path: 'logout', component: NavbarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
