import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { EmployeeServiceService } from '../../services/employee-service.service';
import { PC } from '../../models/PC';
import { Employee } from '../../models/Employee';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {

  allPC:any
  data:any
  pc1:any
  pc2:PC;
  employee:Employee;
  show:boolean=false;
 
  constructor(private _service:EmployeeServiceService,private router:Router) { }

  ngOnInit() {
    this.employee=JSON.parse(localStorage.getItem('emp'));

    if(this.employee.pc!=null)
    {
        alert("Please release the current PC to request for new PC")
        this.router.navigate(['/successLink/releaseLink'])

    }
    this._service.getAllPC().subscribe(
      (res)=>{
          console.log(res+"success");
          this.allPC=res;
          
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

  }

  onChange(event, pc: PC){ // Use appropriate model type instead of any
    this.pc2=pc;
    console.log(this.pc2.status)
    if(this.pc2.status==1)
    {
        alert("This PC is already alloted check the form to see the available date")
        this.show=true;
    }
    else{
        this.show=false;
    }

    if(this.pc2.startDate>this.pc2.endDate)
    {
        alert("select correct date")
    }

}

submit(){
    if(this.pc2.startDate==null)
    alert("Enter Start date")
    else if(this.pc2.endDate==null)
    alert("Enter End date")
    else{
console.log(this.pc2);
this.employee.pc=this.pc2;
console.log(this.employee)
this._service.allocatePC(this.employee).subscribe(
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
alert("PC number:"+this.employee.pc.pcNo+" is successfully alloted")
return("");
}
}

reset()
{
  this.pc2=new PC();
}

}
