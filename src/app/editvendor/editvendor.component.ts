import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { ActivatedRoute, Router } from '@angular/router';
import { AddvendorService } from '../addvendor.service';

@Component({
  selector: 'app-editvendor',
  templateUrl: './editvendor.component.html',
  styleUrls: ['./editvendor.component.scss']
})
export class EditvendorComponent implements OnInit {
  objVendor=new Vendor();

  constructor(private route: ActivatedRoute,private router:Router,private Insertvendor:AddvendorService) { }

  ngOnInit() {
    this.route.params.subscribe( params => this.getVendorById(params['vendorId']));
  }

  update(): void{
    this.Insertvendor.addVendor(this.objVendor)
      .subscribe((response) =>{
        console.log(response);
       this.router.navigate(['/viewvendor']);
      },(error) =>{console.log(error);
      });
  }
  getVendorById(vendorId: number){
    console.log("Vendor Id " +vendorId);
    this.Insertvendor.getPatientById(vendorId)
    .subscribe((searchData) =>{
      this.objVendor=searchData;
      console.log(searchData);
    }, (error) =>{
      console.log(error);
    });
  }

  Goback():void{
    this.router.navigate(['/viewvendor']);
  }

}
