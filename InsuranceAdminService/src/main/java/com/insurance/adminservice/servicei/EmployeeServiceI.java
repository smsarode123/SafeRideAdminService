package com.insurance.adminservice.servicei;

import org.springframework.web.multipart.MultipartFile;

import com.insurance.adminservice.model.Employee;

public interface EmployeeServiceI {

	Employee saveEmployee(String documentjson, MultipartFile pancard, MultipartFile profile);

	void removeEmployeeById(int empoyeeId);

	Employee updateEmployeeDataById(Employee emp, int employeeId);

	

	
 
}
