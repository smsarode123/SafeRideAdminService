package com.insurance.adminservice.serviceimpl;

import java.io.IOError;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.adminservice.exception.InvalidEmployeeIdException;
import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.repository.AccountDetailsRepository;
import com.insurance.adminservice.repository.EmployeeRepository;
import com.insurance.adminservice.repository.ServiceCenterRepository;
import com.insurance.adminservice.servicei.EmployeeServiceI;
import com.insurance.adminservice.utility.UsernameAndPasswordUtility;

import com.thoughtworks.xstream.mapper.Mapper;
@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
	
	@Autowired private AccountDetailsRepository accuntDetailsRepository;
	
	@Autowired private EmployeeRepository employeeRepository;
	
	@Autowired private ServiceCenterRepository serviceCenterRepository;

	


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
	public Employee saveEmployee(String documentjson, MultipartFile pancard, MultipartFile profile) 
	{
		Employee emp=new Employee();
		 ObjectMapper object=new ObjectMapper();
		 
		 try {
			 
		    	emp =object.readValue(documentjson,Employee.class);
			
			String fivechar=emp.getEmployeeName().substring(0, 4);
			emp.setUsername(UsernameAndPasswordUtility.genrateUsername(fivechar));
			emp.setPassword(UsernameAndPasswordUtility.genratePassword(fivechar));
			
			 emp.setPancardImgae(pancard.getBytes());
			 emp.setProfileImage(profile.getBytes());
			}
		 catch( IOException e)
		 {
			 e.printStackTrace();
		 }
		 
		 
		return employeeRepository.save(emp);

		
	

	}

	

	
	 

}
