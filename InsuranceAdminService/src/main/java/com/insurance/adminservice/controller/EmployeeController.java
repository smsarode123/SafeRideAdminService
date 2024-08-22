package com.insurance.adminservice.controller;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.servicei.AdminServiceI;

@RestController
public class EmployeeController {
	
	@Autowired AdminServiceI service; 
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		Employee employeeRef = service.saveEmployee(employee);
		
		return new ResponseEntity<Employee>(employeeRef, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String>removeEmployee(@PathVariable ("employeeId") int empoyeeId)
	{
		
		service.removeEmployeeById(empoyeeId);
		
		return new ResponseEntity<String>("Employee Data Deleted Successfully",HttpStatus.GONE);
	}
	
	
	
}
