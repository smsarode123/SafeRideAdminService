package com.insurance.adminservice.servicei;

import java.util.List;

import com.insurance.adminservice.model.Employee;

public interface AdminServiceI {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

}
