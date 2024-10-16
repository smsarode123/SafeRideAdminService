package com.insurance.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.servicei.EmployeeServiceI;
@CrossOrigin("http://localhost:3000")
@RestController
public class EmployeeController {
	
	@Autowired EmployeeServiceI service; 
	
	
	
	
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestPart ("pancard") MultipartFile pancard,
			                                     @RequestPart ("data") String documentjson,
			                                     @RequestPart ("profile") MultipartFile profile)
	{
		Employee employeeRef = service.saveEmployee(documentjson,pancard,profile);
		return new ResponseEntity<Employee>(employeeRef, HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployeeByUsernameAndPassword/{username}/{password}")
	public ResponseEntity<Employee> getEmployeeByUsernameAndPassword(@PathVariable String username ,
																	 @PathVariable String password)
	{
		
		Employee emp=service.getEmployeeByUsernameAndPassword(username,password);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<String> removeEmployee(@PathVariable("employeeId") int empoyeeId) {

		service.removeEmployeeById(empoyeeId);

		return new ResponseEntity<String>("Employee Data Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") int employeeId,
			                                       @RequestPart ("pancard") MultipartFile pancard,
				                                   @RequestPart ("data") String documentjson,
				                                   @RequestPart ("profile") MultipartFile profile) 
	{

		Employee employee = service.updateEmployeeDataById(employeeId, pancard, profile, documentjson);

		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = service.getAllEmployee();

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}

	@GetMapping("/getSingleEmployee/{employeeId}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable("employeeId") int employeeId) {
		Employee employeeRef = service.getSingleEmployee(employeeId);

		return new ResponseEntity<Employee>(employeeRef, HttpStatus.OK);
	}

}
