package com.pcm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;


@Entity(name="pc")
@NamedNativeQuery(name="PC.pcDetails", query="select * from pc p join location l on p.fk_location_id=l.location_id")
public class PC {

	public PC() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="pc_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pcNo;
	
	
	@Column(name="status")
	private int status;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_location_id")
	private Location location;


	public int getPcNo() {
		return pcNo;
	}


	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public PC(int pcNo, int status, Date startDate, Date endDate, Location location) {
		super();
		this.pcNo = pcNo;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}


	@Override
	public String toString() {
		return "PC [pcNo=" + pcNo + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", location=" + location + "]";
	}
	
	

}
