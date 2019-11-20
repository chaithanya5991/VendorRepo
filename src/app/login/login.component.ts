import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Vendor } from '../vendor';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login=new Vendor();
  logins:Vendor[];
  message:string;
  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit() {
  }

  OnSubmit(form:NgForm){
    this.validLogin(form);
  }
  validLogin(form:NgForm){
 
    this.loginService.getRoleId(form.value).subscribe(data=>{
    console.log(data);
    this.login=data;
   
  
    console.log(this.login);
     
     if(this.login.userId==1){
       console.log(data.username);
       this.router.navigate(['/viewvendor']);
     }
     else if(this.login.userId==2){
       console.log(data.username);
       this.router.navigate(['/viewvendor']);
     }
     
     
     else{
       this.message="Incorrect username or password";
     }
   },
   (error) =>{
     console.log(error);
   });
   }

}
