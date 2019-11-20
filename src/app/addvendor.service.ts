import { Injectable } from '@angular/core';
import { Vendor } from './vendor';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddvendorService {

  formData: Vendor

  constructor(private _httpService: HttpClient,private router:Router) { }

  addVendor(objVendor :Vendor){
    let body = JSON.stringify(objVendor);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
  
    if(objVendor.vendorId)
    {
      return this._httpService.put(environment.APIUrl +'/saveDetails', body, options);
    }
    else{
      return this._httpService.post(environment.APIUrl +'/saveDetails', body, options);
    }
    
  }

  getPatientById(vendorId: number): Observable<Vendor>{
    // return this._httpService.get<Front>(environment.APIUrl +'/patientdetails/'+ regId);
    return this._httpService.get<Vendor>(environment.APIUrl +'/getVendorById/'+ vendorId);
  }

}
