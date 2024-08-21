package com.insurance.adminservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.insurance.adminservice.model.ServiceCenter;
import com.insurance.adminservice.repository.ServiceCenterRepository;
import com.insurance.adminservice.servicei.ServiceCenterService;

public class ServiceCenterImpl implements ServiceCenterService{
	
	
	@Autowired private ServiceCenterRepository repository;

	@Override
	public ServiceCenter saveServiceCenter(ServiceCenter serviceCenter) {
		
		return repository.save(serviceCenter);
	}
}
