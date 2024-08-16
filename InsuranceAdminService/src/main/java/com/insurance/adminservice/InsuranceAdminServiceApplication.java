package com.insurance.adminservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class InsuranceAdminServiceApplication {

	public static void main(String[] args) {
		System.out.println("This is Admin service");
		SpringApplication.run(InsuranceAdminServiceApplication.class, args);
		
		
	}

}
