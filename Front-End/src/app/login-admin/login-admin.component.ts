import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookStoreService } from '../book-store.service';
import { BookStoreConstantsService } from '../book-store-constants.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  admin:any;
  email:string;
  password:string;
  isSubmitted: boolean = false;
  checkError:boolean=false;
  checkInfo:boolean=false;
  errorMessage:string;
  constructor(private service:BookStoreService, private appComponent : AppComponent) {
    
  }

  ngOnInit(){
    
    

  }
  onSubmit(form:NgForm)
  { console.log(this.email);
    console.log(this.password);
    this.checkInfo=false;
    this.checkError=false;
    
    this.service.loginAdmin(this.email,this.password).subscribe(
    (data)=>
    { 
      form.reset();
      this.admin=data;
      this.checkInfo=true;
      this.checkError=false;
      // alert("LoggedIn Succesfully");
      console.log(this.admin);
     window.location.href="/displayCategory";
      localStorage.setItem("adminId",this.admin.adminId);
      localStorage.setItem("email",this.admin.email);
      localStorage.setItem("fullName",this.admin.fullName);
      localStorage.setItem("password",this.admin.password);

    },
    
    (error)=>
    {this.errorMessage=error.error.message;
      this.checkError=true;
      this.checkInfo=false;
    });

    this.appComponent.loggedIn=true;
  }


}
