import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from './vendor';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViewallService {

  formData: Vendor
  
  constructor(private _httpService: HttpClient,private router:Router) { }

  getAllDetails(): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/getallvendors');
  }

  SearchDetails(search:string): Observable<Vendor[]>{
    console.log(search)
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/vendorsearch/'+search);
  }

  disableVendor(vObj: Vendor){
    let body=JSON.stringify(vObj);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    return this._httpService.put(environment.APIUrl+'/disable',body,options);
  }
}
