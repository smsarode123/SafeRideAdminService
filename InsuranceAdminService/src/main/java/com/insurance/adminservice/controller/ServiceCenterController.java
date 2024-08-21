package com.insurance.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	

	
}
