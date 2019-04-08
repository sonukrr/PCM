package com.pcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;


@Component

@Entity(name="employee")
@NamedNativeQueries({
	@NamedNativeQuery(name ="Employee.signin", query = "select * from employee e where emp_id=? and password=?"),
	@NamedNativeQuery(name ="Employee.getEmployeeDetails", query = "select * from employee e join PC p join location l on e.fk_pc_no=p.pc_no and p.fk_location_id=l.location_id where e.emp_id=?")  
})

public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="emp_location")
	private String empLocation;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_pc_no")
	private PC pc;


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmpLocation() {
		return empLocation;
	}


	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}


	public PC getPc() {
		return pc;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", empLocation="
				+ empLocation + ", pc=" + pc + "]";
	}


	public void setPc(PC pc) {
		this.pc = pc;
	}


	public Employee(int empId, String empName, String password, String empLocation, PC pc) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.empLocation = empLocation;
		this.pc = pc;
	}
	
	
	
	
	
	
	

}
