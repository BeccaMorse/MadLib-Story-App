import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StoryRoutingModule } from './story-routing.module';
import { StoryHomeComponent } from './story-home/story-home.component';


@NgModule({
  declarations: [StoryHomeComponent],
  imports: [
    CommonModule,
    StoryRoutingModule
  ]
})
export class StoryModule { }
