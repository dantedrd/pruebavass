import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ClientsComponent } from './clients/clients.component';
import { FormsModule } from '@angular/forms';
import { CreateclientsmodalComponent } from './createclientsmodal/createclientsmodal.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent,
    CreateclientsmodalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
