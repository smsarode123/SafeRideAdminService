package com.insurance.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
