package com.insurance.adminservice.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.adminservice.exception.ServiceCenterIdIsNotFoundException;
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

	@Override
	public void removeServiceCenterById(int serviceCenterId) {
		
	Optional<ServiceCenter>service=repository.findById(serviceCenterId);
		if(service.isPresent())
		{
			repository.deleteById(serviceCenterId);
		}
		
		else
		{
			
			throw new ServiceCenterIdIsNotFoundException("Service Center Id   "+serviceCenterId+"  Is Not Present");
		}
		
		
	}

	@Override
	public ServiceCenter UpdateServiceCenterDataById(ServiceCenter service, int servicecenterId) {

		Optional<ServiceCenter>servicecenter=repository.findById(servicecenterId);
		if(servicecenter.isPresent())
		{
			
			return repository.save(service);
			
		}
		else
		{
			
			throw new ServiceCenterIdIsNotFoundException("ServiceCenter Id    "+servicecenterId+"    Is NOt Present");
		}
		
		
	}
} 
