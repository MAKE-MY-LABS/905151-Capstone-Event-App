import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventsComponent } from './events.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/utilities/shared.module';



@NgModule({
  declarations: [
    EventsComponent
  ],
  imports: [
    CommonModule,
    CommonModule,
    // add shared module
    SharedModule,
    // add router module
    RouterModule.forChild([
      {
        path: '',
        component: EventsComponent
      }
    ])
  ]
})
export class EventsModule { }
