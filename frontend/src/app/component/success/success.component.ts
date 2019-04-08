import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../../services/employee-service.service';
import { PC } from '../../models/PC';
import { Employee } from '../../models/Employee';
import { Router} from '@angular/router';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  allPC:any
  employee:Employee=new Employee();
  data:any;

  constructor(private _service:EmployeeServiceService,private router:Router) { }

  ngOnInit() {
    this.employee=JSON.parse(localStorage.getItem("emp"))
    

    this._service.getEmployeeDetails(this.employee).subscribe(
      (res)=>{
          console.log(res+"success");
          if(res!=null){
          this.employee=res;
          localStorage.setItem("emp",JSON.stringify(this.employee))}
          
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
  
  this.router.navigate(['/successLink/releaseLink']); 

  }

  logout():any{
      localStorage.clear();
      this.router.navigate(['/homeLink']); 

  }

}

