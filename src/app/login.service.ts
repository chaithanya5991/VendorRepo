import { Injectable } from '@angular/core';
import { Vendor } from './vendor';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  formData: Vendor
  constructor(private _httpService: HttpClient,private router:Router) {
    
   }

   getRoleId(formData:any):any{
    return this._httpService.get<Vendor>(environment.APIUrl+'login/'+formData.username+'/'+formData.password);
  }

  logout():void{
    localStorage.setItem('isLoggedIn','false');
    localStorage.removeItem('token');
    localStorage.removeItem('tokenRoleId');
    this.router.navigate(['/login']);
   

  }

}
