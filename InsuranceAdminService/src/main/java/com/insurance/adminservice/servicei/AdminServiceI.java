package com.insurance.adminservice.servicei;

import com.insurance.adminservice.model.Employee;

public interface AdminServiceI {

	Employee saveEmployee(Employee employee);

	void removeEmployeeById(int empoyeeId);

	Employee updateEmployeeDataById(Employee emp, int employeeId);

}
