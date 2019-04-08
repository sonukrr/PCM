export class Location {

  public locationId: number;
  public locationName: string;
    constructor(
    
    ) {  }

  
    getLocationId(): number
    {
      return this.locationId;
    }
    getLocationName(): string
    {
      return this.locationName;
    }
    setlocationId(locationId:number)
    {
       this.locationId=locationId;
    }
    setLocationName(locationName:string)
    {
      this.locationName=locationName;
    }

    data():string{
      return "locationId:"+this.locationId+"locationName:"+this.locationName;
    }
  }