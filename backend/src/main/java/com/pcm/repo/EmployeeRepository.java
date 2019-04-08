package com.pcm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public  List<Object[]> signin(@Param("emp_id") int empId ,@Param("password") String password);
	public  List<Object[]> getEmployeeDetails(@Param("emp_id") int empId);

}
