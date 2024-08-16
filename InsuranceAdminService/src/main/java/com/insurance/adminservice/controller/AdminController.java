package com.insurance.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.servicei.AdminServiceI;

@RestController
public class AdminController {
	
	@Autowired AdminServiceI service; 
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list=service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
	}

}
