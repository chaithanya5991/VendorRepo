import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';
import { AddvendorComponent } from './addvendor/addvendor.component';
import { EditvendorComponent } from './editvendor/editvendor.component';


const routes: Routes = [

  {path:'',redirectTo:'/login',pathMatch:'full'},
  { path: 'login', component:LoginComponent},
  { path: 'viewvendor', component:ViewvendorComponent},
  { path: 'addvendor', component:AddvendorComponent},
  { path: 'editvendor/:vendorId', component:EditvendorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
