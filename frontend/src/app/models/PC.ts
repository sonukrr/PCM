import { Location } from './Location';

export class PC {

  public pcNo: number
  public status: number
  public startDate: Date
  public endDate: Date
  public location: Location 
    constructor(

    ) {  }
  
    getPcNo(): number
    {
      return this.pcNo;
    }
    getStatus(): number
    {
      return this.status;
    }
    
    getStartDate(): Date
    {
      return this.startDate;
    }
    getEndDate(): Date
    {
      return this.endDate;
    }
    getLocation(): Location
    {
      return this.location;
    }
   
    data():string{
      return "pcNo:"+this.pcNo+"status:"+this.status+"start date:"+this.startDate+"end date:"+this.endDate+"location:"+this.location;
    }
  
  }