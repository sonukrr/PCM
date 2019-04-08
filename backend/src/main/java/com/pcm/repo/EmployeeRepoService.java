package com.pcm.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pcm.model.Employee;


@Service
public class EmployeeRepoService {

	public EmployeeRepoService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> fetchAllEmployee(){
		return employeeRepository.findAll();
	}
	
	
	public Employee saveEmp(Employee emp){
		
		
		return employeeRepository.save(emp);
	}
	
	public List<Object[]> loginCheck(Employee employee){
		
		
		 return employeeRepository.signin(employee.getEmpId(), employee.getPassword());
		 
		 
	}
	
	public List<Object[]> getEmployeeDetails(Employee employee){
		
		
		 return employeeRepository.getEmployeeDetails(employee.getEmpId());
			 
	}
	
	
	
	
}
