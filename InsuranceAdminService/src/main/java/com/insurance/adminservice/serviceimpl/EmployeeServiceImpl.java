package com.insurance.adminservice.serviceimpl;


import java.io.IOError;
import java.io.IOException;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
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

	@Autowired
	private AccountDetailsRepository accuntDetailsRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ServiceCenterRepository serviceCenterRepository;



	@Override
	public void removeEmployeeById(int empoyeeId) {

		Optional<Employee> emp = employeeRepository.findById(empoyeeId);

		if (emp.isPresent()) {
			employeeRepository.deleteById(empoyeeId);
		} else {

			throw new InvalidEmployeeIdException("Employee Id  " + empoyeeId + "  Is Not Present");
		}

	}


	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> employees = employeeRepository.findAll();

		return employees;

	}

	@Override
	public Employee getSingleEmployee(int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new InvalidEmployeeIdException("Employee Id" + employeeId + " Is Not Present For Update Operation");
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

	@Override
	public Employee getEmployeeByUsernameAndPassword(String username, String password) {
		Optional< Employee> empolOptional= employeeRepository.findByUsernameAndPassword(username, password);
		if(empolOptional.isPresent()) {
			
			return empolOptional.get();
		}else {
			throw new InvalidEmployeeIdException("Wrong Username :- "+username+" And PassWord :- " +password + " Wrong Input");
		}
	}

	@Override
	public Employee updateEmployeeDataById(int employeeId, MultipartFile pancard, MultipartFile profile,
			String documentjson) {
		Employee emp=null;
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			emp=objectMapper.readValue(documentjson, Employee.class);
			
			String fivechar=emp.getEmployeeName().substring(0, 4);
			emp.setUsername(UsernameAndPasswordUtility.genrateUsername(fivechar));
			emp.setPassword(UsernameAndPasswordUtility.genratePassword(fivechar));
			
			 emp.setProfileImage(profile.getBytes());
			 emp.setPancardImgae(pancard.getBytes());
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return employeeRepository.save(emp); 
	}

	

	
	 


}
