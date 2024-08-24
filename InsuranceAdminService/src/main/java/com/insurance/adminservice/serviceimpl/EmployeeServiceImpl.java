package com.insurance.adminservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.adminservice.exception.InvalidEmployeeIdException;
import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.repository.AccountDetailsRepository;
import com.insurance.adminservice.repository.EmployeeRepository;
import com.insurance.adminservice.repository.ServiceCenterRepository;
import com.insurance.adminservice.servicei.EmployeeServiceI;
import com.insurance.adminservice.utility.UsernameAndPasswordUtility;
@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
	
	@Autowired private AccountDetailsRepository accuntDetailsRepository;
	
	@Autowired private EmployeeRepository employeeRepository;
	
	@Autowired private ServiceCenterRepository serviceCenterRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		String firstFiveChr=employee.getEmployeeName().substring(0, 4);
		 employee.setUsername(UsernameAndPasswordUtility.genrateUsername(firstFiveChr));
		 employee.setPassword(UsernameAndPasswordUtility.genratePassword(firstFiveChr));
		 
		
		return employeeRepository.save(employee);
	}

	@Override
	public void removeEmployeeById(int empoyeeId) {
	
	Optional<Employee> emp=employeeRepository.findById(empoyeeId);
		
	if(emp.isPresent())
	{
		employeeRepository.deleteById(empoyeeId);
	}
	else
	{
		
		throw new InvalidEmployeeIdException("Employee Id  "+empoyeeId+"  Is Not Present");
	}
	
		
	}

	@Override
	public Employee updateEmployeeDataById(Employee emp, int employeeId) {
		
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isPresent())
		{
			
			
			return employeeRepository.save(emp);
		}
		else
		{
			throw new InvalidEmployeeIdException("Employee Id"+employeeId+" Is Not Present For Update Operation");
		}
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return null;
	}
	
	 

}
