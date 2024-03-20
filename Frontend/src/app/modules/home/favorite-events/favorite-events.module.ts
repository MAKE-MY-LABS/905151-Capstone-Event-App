import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FavoriteEventsComponent } from './favorite-events.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/utilities/shared.module';



@NgModule({
  declarations: [
    FavoriteEventsComponent
  ],
  imports: [
    CommonModule,
     // add shared module
     SharedModule,
     // add router module
     RouterModule.forChild([
       {
         path: '',
         component: FavoriteEventsComponent
       }
     ])
  ]
})
export class FavoriteEventsModule { }
