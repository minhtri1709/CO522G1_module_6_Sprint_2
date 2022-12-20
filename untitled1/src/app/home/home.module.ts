import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { BodyComponent } from './footer/body/body.component';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CartComponent } from './cart/cart.component';


@NgModule({
  declarations: [FooterComponent, HeaderComponent, HomepageComponent, BodyComponent, LoginComponent, CartComponent],
    exports: [
        FooterComponent,
        HeaderComponent
    ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class HomeModule { }
