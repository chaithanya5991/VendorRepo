import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { AddvendorService } from '../addvendor.service';
import { Router } from '@angular/router';
import { ViewallService } from '../viewall.service';

@Component({
  selector: 'app-addvendor',
  templateUrl: './addvendor.component.html',
  styleUrls: ['./addvendor.component.scss']
})
export class AddvendorComponent implements OnInit {
  objVendor=new Vendor();
  vendors: Vendor[];

  constructor(private router:Router,private Insertvendor:AddvendorService,private viewall:ViewallService) { }

  ngOnInit() {
  }

  save():void{this.Insertvendor.addVendor(this.objVendor)
    .subscribe((response)=>{
      console.log(response);
      this.reset();
      this.router.navigate(['/viewvendor'])
    },(error)=>{
      console.log(error);    
    });
  }

  getAllDetails():void{
    this.viewall.getAllDetails()
    .subscribe((patientdata)=>{
    this.vendors=patientdata,
    console.log(patientdata);
    },(error)=>{console.log(error);
    });
  }
  private reset(){
    this.objVendor.vendorName=null;
    this.objVendor.address=null;
    this.objVendor.location=null;
    this.objVendor.service=null;
    this.objVendor.pincode=null;
    this.objVendor.name=null;
    this.objVendor.department=null;
    this.objVendor.email=null;
    this.objVendor.phone=null;

  }

  Goback():void{
    this.router.navigate(['/viewvendor']);
  }
}
