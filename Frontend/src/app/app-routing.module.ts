import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckTokenGuard } from './utilities/check-token.guard';

const routes: Routes = [

  // add login route usinf loginmodule lazy loading
  {
    path: 'login',
    loadChildren: () => import('./modules/login/login.module').then(m => m.LoginModule)
  },

  // add home route using home module lazy loading

  {
    path: 'capstone-event-app',
    loadChildren: () => import('./modules/home/home.module').then(m => m.HomeModule),
    canActivate: [CheckTokenGuard]

  },

  // add default rount to login

  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
