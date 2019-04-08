import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { LandingComponent } from './component/landing/landing.component';
import { HomeComponent } from './component/home/home.component';
import { SuccessComponent } from './component/success/success.component';
import { ReleaseComponent } from './component/release/release.component';
import { RequestComponent } from './component/request/request.component';

const routes: Routes = [
  
  {path:"homeLink",component:HomeComponent,
  children: [
  {path:"loginLink",component:LoginComponent},
  {path:"registerLink",component:RegisterComponent}
  ]
},

{path:"successLink",component:SuccessComponent,
  children: [
  {path:"releaseLink",component:ReleaseComponent},
  {path:"requestLink",component:RequestComponent}
  ]
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
