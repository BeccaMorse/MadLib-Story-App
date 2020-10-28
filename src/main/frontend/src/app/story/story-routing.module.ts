import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { homedir } from 'os';
import { StoryHomeComponent } from './story-home/story-home.component';

const routes: Routes = [
  { path: 'templates', component: StoryHomeComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule, StoryHomeComponent]
})
export class StoryRoutingModule { }
