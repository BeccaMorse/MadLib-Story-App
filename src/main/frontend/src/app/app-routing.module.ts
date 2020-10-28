import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginHomeComponent } from './login/login-home/login-home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterHomeComponent } from './register/register-home/register-home.component';
import { StoryHomeComponent } from './story/story-home/story-home.component';

const routes: Routes = [
  { path: 'login', component: LoginHomeComponent },
  { path: 'register', component: RegisterHomeComponent },
  { path: 'logout', component: NavbarComponent },
  { path: 'templates', component: StoryHomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
