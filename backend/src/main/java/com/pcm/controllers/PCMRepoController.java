package com.pcm.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcm.model.Employee;
import com.pcm.model.Location;
import com.pcm.model.PC;
import com.pcm.repo.EmployeeRepoService;
import com.pcm.repo.LocationRepoService;
import com.pcm.repo.PCRepoService;

@CrossOrigin
@RestController
public class PCMRepoController {

	public PCMRepoController() {
		// TODO Auto-generated constructor stub
	}

	
	@Autowired
	private EmployeeRepoService employeeRepoService;
	
	@Autowired
	private PCRepoService pcRepoService;
	
	
	@Autowired
	private LocationRepoService locationRepoService;
	
	
	
	@GetMapping("/getallemp")
	public List<Employee> getemployee()
	{
		return employeeRepoService.fetchAllEmployee();
	}
	
	@GetMapping("/getallLocation")
	public List<Location> getallLocation()
	{
		return locationRepoService.fetchallLocation();
	}
	
	@PostMapping("saveemp")
	public Employee saveEmp(@RequestBody Employee employee){
		
		System.out.println(employee);
		return employeeRepoService.saveEmp(employee);
		
		
		
	}
	@PostMapping("/allotpc")
	public Employee allotpc(@RequestBody Employee employee)
	{
		
		System.out.println(employee);
		employee.getPc().setStatus(1);
		PC updatedPc=pcRepoService.savePc(employee.getPc());
		employee.setPc(updatedPc);
		return employeeRepoService.saveEmp(employee);
		
	}
	
	
	@PostMapping("loginCheck")
	public Employee loginCheck(@RequestBody Employee employee)
	{
		
		List<Object[]> listObj=employeeRepoService.loginCheck(employee);
		if(listObj.size()>0){
			System.out.println(listObj);
			
		Object[] obj=listObj.get(0);
		PC pc=new PC();
		Employee emp=new Employee();
		emp.setEmpId((int)obj[0]);
		emp.setEmpName(String.valueOf(obj[1]));
		emp.setPassword(String.valueOf(obj[2]));
		emp.setEmpLocation(String.valueOf(obj[3]));
		if(obj[4]!=null)
		{
			pc.setPcNo((int)obj[4]);
			emp.setPc(pc);
		}
		
		
		return emp;
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("getpcdetails")
	public List<PC> getPcDetails(){
		
		List<Object[]> objarr=pcRepoService.pcDetails();
		List<PC> pcList=new ArrayList<PC>();
		for(Object[] obj:objarr)
		{
			PC pc =new PC();
			Location loc=new Location(); 
			
			loc.setLocationId((int)obj[5]);
			loc.setLocationName(String.valueOf(obj[6]));
		
			pc.setPcNo((int)obj[0]);
			pc.setStatus((int)obj[1]);
			pc.setStartDate((Date)obj[2]);
			pc.setEndDate((Date)obj[3]);
			pc.setLocation(loc);
			
			pcList.add(pc);
		}
		
		return pcList;

	}
	
	@PostMapping("/releasepc")
	public Employee releasepc(@RequestBody Employee employee)
	{
		System.out.println(employee+"release");
		employee.getPc().setStatus(0);
		employee.getPc().setStartDate(null);
		employee.getPc().setEndDate(null);
		PC updatedPc=pcRepoService.savePc(employee.getPc());
		employee.setPc(null);
		
		Employee updatedEmployee=employeeRepoService.saveEmp(employee);
		System.out.println(updatedEmployee+"afterrelease");
		return updatedEmployee;
				
	}
	
	
	@PostMapping("getEmployeeDetails")
	public Employee getEmployeeDetails(@RequestBody Employee employee)
	{
		
		List<Object[]> listObj=employeeRepoService.getEmployeeDetails(employee);
		if(listObj.size()>0){
			System.out.println(listObj);
			
		Object[] obj=listObj.get(0);
		PC pc=new PC();
		Location loc=new Location();
		Employee emp=new Employee();
		emp.setEmpId((int)obj[0]);
		emp.setEmpName(String.valueOf(obj[1]));
		emp.setPassword(String.valueOf(obj[2]));
		emp.setEmpLocation(String.valueOf(obj[3]));
		if(obj[4]!=null)
		{
			pc.setPcNo((int)obj[5]);
			pc.setStatus((int)obj[6]);
			pc.setStartDate((Date)obj[7]);
			pc.setEndDate((Date)obj[8]);
			
			loc.setLocationId((int)obj[10]);
			loc.setLocationName(String.valueOf(obj[11]));
			
			pc.setLocation(loc);
		}
		emp.setPc(pc);
		
		return emp;
		}
		else
		{
			return null;
		}
	}
	
	
	
	
	
}
