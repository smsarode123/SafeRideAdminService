package com.insurance.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.adminservice.servicei.AdminServiceI;

@RestController
public class AdminController {
	
	@Autowired AdminServiceI service; 

}
