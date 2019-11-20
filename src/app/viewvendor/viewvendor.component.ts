import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { ViewallService } from '../viewall.service';

@Component({
  selector: 'app-viewvendor',
  templateUrl: './viewvendor.component.html',
  styleUrls: ['./viewvendor.component.scss']
})
export class ViewvendorComponent implements OnInit {
  objVendor: Vendor[];
  search:string;
  constructor(private router:Router,private viewall:ViewallService,private loginserv:LoginService) { }

  ngOnInit() {

    this.getAllDetails();
  }

  getAllDetails():void{
    this.viewall.getAllDetails()
    .subscribe((patientdata)=>{
    this.objVendor=patientdata,
    console.log(patientdata);
    },(error)=>{console.log(error);
    });
  }

  SearchDetails(search:string):void{
    if(search!=null){
    this.viewall.SearchDetails(search)
    .subscribe((patdata)=>{
    this.objVendor=patdata,
    this.search=undefined;
    console.log(patdata);
    },(error)=>{console.log(error);
    });
  }else{
    this.getAllDetails();
  }
  }

  disableVendor(vObj: Vendor){
    console.log("Disable");
      this.viewall.disableVendor(vObj)
      .subscribe((response) =>{
        this.getAllDetails();
      }, (error) =>{
        console.log(error);
      });
  }

  newVendor():void{
    this.router.navigate(['/addvendor']);
  }
  
  edit(vendorId:number):void{
    this.router.navigate(['/editvendor/',vendorId]);
  }

  logout():void{
    this.loginserv.logout();
  
  }

}
