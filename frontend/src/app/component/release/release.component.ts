import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/Employee';
import { EmployeeServiceService } from '../../services/employee-service.service';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-release',
  templateUrl: './release.component.html',
  styleUrls: ['./release.component.css']
})
export class ReleaseComponent implements OnInit {
  employee:Employee;
  show:boolean=false;
  data:any

  constructor(private empservice:EmployeeServiceService) { }

  ngOnInit() {
    this.employee=JSON.parse(localStorage.getItem("emp"));
    if(this.employee.pc!=null)
    this.show=true;
  }

  release():any
  {
    console.log(this.employee)
    
    this.empservice.releasePC(this.employee).subscribe(
      (res)=>{
          console.log(res+"success");
          this.employee=res;
          
              //this.employee=this._service.getEmployeeDetails(this.employee);
             localStorage.setItem("emp",JSON.stringify(this.employee));              
  
          
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
  this.show=false;
  return(this.employee);

  }

}
