package com.insurance.adminservice.servicei;

import java.util.List;

import com.insurance.adminservice.model.Employee;

public interface EmployeeServiceI {

	Employee saveEmployee(Employee employee);

	void removeEmployeeById(int empoyeeId);

	Employee updateEmployeeDataById(Employee emp, int employeeId);

	List<Employee> getAllEmployee();
 
}
