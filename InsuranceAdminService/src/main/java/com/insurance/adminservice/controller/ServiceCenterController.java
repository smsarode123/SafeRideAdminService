package com.insurance.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.adminservice.model.ServiceCenter;
import com.insurance.adminservice.servicei.ServiceCenterService;

@RestController
public class ServiceCenterController {
	
	
	@Autowired ServiceCenterService scs;
	
	
	@PostMapping("/saveservicecenter")
	public ResponseEntity<ServiceCenter> saveServiceCenter(@RequestBody ServiceCenter serviceCenter)
	{
		ServiceCenter serviceCenterRef = scs.saveServiceCenter(serviceCenter);
		
		return new ResponseEntity<ServiceCenter>(serviceCenterRef, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteservicecenter/{serviceCenterId}")
	public ResponseEntity<String>deletedServiceCenter(@PathVariable ("serviceCenterId") int serviceCenterId)
	{
		scs.removeServiceCenterById(serviceCenterId);
		
		return  new ResponseEntity<String>("ServiceCnter Data Deleted Successfully", HttpStatus.GONE);
	}
	
	@PutMapping("/updateservicecenter/{serviceCenterId}")
	public ResponseEntity<ServiceCenter>updateServiceCenter(@PathVariable ("serviceCenterId") int servicecenterId,@RequestBody ServiceCenter service)
   {
		
		ServiceCenter servicecenterdata=scs.UpdateServiceCenterDataById(service,servicecenterId);
		
		return new ResponseEntity<ServiceCenter>(servicecenterdata, HttpStatus.ACCEPTED);
   }
 	
}
