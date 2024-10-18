package com.insurance.adminservice.servicei;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.insurance.adminservice.model.Employee;

public interface EmployeeServiceI {

	Employee saveEmployee(String documentjson, MultipartFile pancard, MultipartFile profile);

	void removeEmployeeById(int empoyeeId);



	

	List<Employee> getAllEmployee();

	Employee getSingleEmployee(int employeeId);

	Employee getEmployeeByUsernameAndPassword(String username, String password);

	Employee updateEmployeeDataById(int employeeId, MultipartFile pancard, MultipartFile profile, String documentjson);

 
}
