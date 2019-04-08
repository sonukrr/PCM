import { PC } from './PC';

export class Employee {

    public empId: number
    public empName: string
    public password: string
    public empLocation: string
    public pc: PC 

    constructor( ) { }

    getEmpId(): number
    {
      return this.empId
    }

    getEmpName(): string
    {
      return this.empName
    }
    getPassword(): string
    {
      return this.password
    }
    getEmpLocation(): string
    {
      return this.empLocation
    }
    getPC(): PC
    {
      return this.pc
    }
    setPC(pc:PC)
    {
      this.pc=pc
    }

    data():string{
      return "empId:"+this.empId+"empName:"+this.empName+"empLocation"+this.empLocation+"password"+this.password+"PC"+this.pc;
    }
    

  
  }