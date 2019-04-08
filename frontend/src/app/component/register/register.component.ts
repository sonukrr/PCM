import { Component, OnInit } from '@angular/core';
import { FormControl } from "@angular/forms";
import { Router} from '@angular/router';
import { Employee } from '../../models/Employee';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { EmployeeServiceService } from '../../services/employee-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  employee:Employee=new Employee();
  private data:any;
  locations:any

  constructor(private router:Router,private _service:EmployeeServiceService){}
  
  ngOnInit() {

    this._service.getAllLocation().subscribe(
      (res)=>{
          console.log(JSON.stringify(res+"success"));
          this.locations=res;
          
      },(error:HttpErrorResponse)=>{

          if(error instanceof Error)
          {
              console.log("Client side error"+error);
          }

          else
          {
              console.log("server side error"+error);
          }
          this.locations=error;
      }
  );
  }

  register():void{
    console.log(this.employee);
        this._service.register(this.employee).subscribe(
            (res)=>{
                console.log(JSON.stringify(res+"success"));
                this.employee=res;
                alert(this.employee.empId+" is your employee ID")
                
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
        
        console.log(this.employee)
        console.log(this.data) 
   }
}
