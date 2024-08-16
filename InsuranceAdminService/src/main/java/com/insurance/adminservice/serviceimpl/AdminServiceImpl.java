package com.insurance.adminservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.repository.AccountDetailsRepository;
import com.insurance.adminservice.repository.EmployeeRepository;
import com.insurance.adminservice.repository.ServiceCenterRepository;
import com.insurance.adminservice.servicei.AdminServiceI;
@Service
public class AdminServiceImpl implements AdminServiceI {
	
	@Autowired private AccountDetailsRepository accuntDetailsRepository;
	
	@Autowired private EmployeeRepository employeeRepository;
	
	@Autowired private ServiceCenterRepository serviceCenterRepository;

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll() ;)
	}
	
	

}
