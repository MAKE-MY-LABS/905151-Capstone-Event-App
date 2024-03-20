import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/utilities/shared.module';
import { HeaderComponent } from '../components/header/header.component';



@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    SharedModule, // Add SharedModule to the imports array
    RouterModule.forChild([
      {
        path: 'home',
        component: HomeComponent,
        // lazload articles module, favorite articles module
        children: [
          {
            path: 'events',
            loadChildren: () => import('./../home/events/events.module').then(m => m.EventsModule)
          },
          {
            path: 'favorite-events',
            loadChildren: () => import('./../home/favorite-events/favorite-events.module').then(m => m.FavoriteEventsModule)
          },
          // redirect to events module
          {
            path: 'events',
            redirectTo: 'events',
            pathMatch: 'full'
          }
        ]

      },

    ])
  ]
})
export class HomeModule { }
