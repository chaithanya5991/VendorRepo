import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';
import { HttpClientModule } from '@angular/common/http';
import  {NgxPaginationModule} from 'ngx-pagination';
import { AddvendorComponent } from './addvendor/addvendor.component';
import { EditvendorComponent } from './editvendor/editvendor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewvendorComponent,
    AddvendorComponent,
    EditvendorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
