import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { RequestComponent } from './component/request/request.component';
import { ReleaseComponent } from './component/release/release.component';
import { HomeComponent } from './component/home/home.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LandingComponent } from './component/landing/landing.component';
import { SuccessComponent } from './component/success/success.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    RequestComponent,
    ReleaseComponent,
    HomeComponent,
    LandingComponent,
    SuccessComponent
  ],
  imports: [
    BrowserModule, FormsModule,
    AppRoutingModule,ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [LandingComponent]
})
export class AppModule { }
