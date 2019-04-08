import { Component, OnInit } from '@angular/core';
import { FormControl } from "@angular/forms";
import { Router} from '@angular/router';
import { Employee } from '../../models/Employee';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { EmployeeServiceService } from '../../services/employee-service.service';
import * as $ from 'jquery/dist/jquery.min.js';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employee:Employee=new Employee();
  emp:Employee=new Employee();
  private data:any;

  constructor(private router:Router,private _service:EmployeeServiceService){}
  ngOnInit() {

    $(document).ready(function(){
        $("button").click(function(){
            alert("javascript enabled");
            var div = $("div");  
            div.animate({left: '100px'}, "slow");
            div.animate({fontSize: '5em'}, "slow");
        });
    });
  }
  }

  loginCheck(){
    console.log(this.employee);
    if(this.employee.empId==null)
    alert("Employee ID cannot be null")
    else if(this.employee.password==null)
    alert("Password cannot be null")
    else{
        this._service.loginCheck(this.employee).subscribe(
            (res)=>{
                console.log(res+"success");
                this.employee=res;
                if(this.employee!=null)
                {
                    //this.employee=this._service.getEmployeeDetails(this.employee);
                   localStorage.setItem("emp",JSON.stringify(this.employee));
                    this.router.navigate(['/successLink']);
                }
                else
                {
                    alert("Invalid Employee Id or password");
                }
                
            },(error:HttpErrorResponse)=>{
    
                if(error instanceof Error)
                {
                    console.log("Client side error"+error);
                }
    
                else
                {
                    console.log("server side error"+error);
                }
               this.data=error;
            }
        ); 
        
        console.log(this.data)
   }
}
}



