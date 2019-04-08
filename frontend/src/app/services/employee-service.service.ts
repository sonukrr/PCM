import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Employee } from '../models/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  constructor(private _http: HttpClient) { }

  loginCheck(emp:Employee):any
    {
        return this._http.post("http://localhost:1111/loginCheck",emp)
    }

    register(emp:Employee):any
    {
        return this._http.post("http://localhost:1111/saveemp",emp)
    }

    getAllLocation():any{
        return this._http.get("http://localhost:1111/getallLocation")
    }

    getAllPC():any{
        return this._http.get("http://localhost:1111/getpcdetails")
    }
    getEmployeeDetails(employee):any{
        return this._http.post("http://localhost:1111/getEmployeeDetails",employee)
    }

    releasePC(employee):any{
        return this._http.post("http://localhost:1111/releasepc",employee)
    }

    allocatePC(employee):any{
        return this._http.post("http://localhost:1111/allotpc",employee)
    }
}
