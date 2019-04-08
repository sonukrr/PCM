package com.pcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="location")
public class Location {

	public Location() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="location_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationId;
	
	
	@Column(name="location_name")
	private String locationName;


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String string) {
		this.locationName = string;
	}


	public Location(int locationId, String locationName) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
	}


	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + "]";
	}
	
	
	

}
