package com.insurance.adminservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.adminservice.model.ServiceCenter;
import com.insurance.adminservice.repository.ServiceCenterRepository;
import com.insurance.adminservice.servicei.ServiceCenterService;
@Service
public class ServiceCenterImpl implements ServiceCenterService{
	
	
	@Autowired private ServiceCenterRepository repository;

	@Override
	public ServiceCenter saveServiceCenter(ServiceCenter serviceCenter) {
		
		return repository.save(serviceCenter);
	}
}
