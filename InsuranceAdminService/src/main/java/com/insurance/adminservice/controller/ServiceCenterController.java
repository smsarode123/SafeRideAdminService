package com.insurance.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.adminservice.model.ServiceCenter;
import com.insurance.adminservice.servicei.ServiceCenterService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ServiceCenterController {

	@Autowired
	ServiceCenterService scs;

	@PostMapping("/saveservicecenter")
	public ResponseEntity<ServiceCenter> saveServiceCenter(@RequestBody ServiceCenter serviceCenter) {
		ServiceCenter serviceCenterRef = scs.saveServiceCenter(serviceCenter);

		return new ResponseEntity<ServiceCenter>(serviceCenterRef, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteservicecenter/{serviceCenterId}")
	public ResponseEntity<String> deletedServiceCenter(@PathVariable("serviceCenterId") int serviceCenterId) {
		scs.removeServiceCenterById(serviceCenterId);

		return new ResponseEntity<String>("ServiceCnter Data Deleted Successfully", HttpStatus.GONE);
	}

	@PutMapping("/updateservicecenter/{serviceCenterId}")
	public ResponseEntity<ServiceCenter> updateServiceCenter(@PathVariable("serviceCenterId") int servicecenterId,
			@RequestBody ServiceCenter service) {

		ServiceCenter servicecenterdata = scs.UpdateServiceCenterDataById(service, servicecenterId);

		return new ResponseEntity<ServiceCenter>(servicecenterdata, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllServiceCenter")
	public ResponseEntity<List<ServiceCenter>> getAllServiceCenter() {
		List<ServiceCenter> servicecenter = scs.getAllServiceCenter();

		return new ResponseEntity<List<ServiceCenter>>(servicecenter, HttpStatus.OK);
	}

	@GetMapping("/getSingleServiceCenter/{serviceCenterId}")
	public ResponseEntity<ServiceCenter> getSingleServiceCenterById(
			@PathVariable("serviceCenterId") int serviceCenterId) {

		ServiceCenter servicecenter = scs.getSingleServiceCenterById(serviceCenterId);

		return new ResponseEntity<ServiceCenter>(servicecenter, HttpStatus.OK);
	}

}
