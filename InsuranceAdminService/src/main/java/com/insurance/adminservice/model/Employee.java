package com.insurance.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private String employeeAddress;
	private long employeeContactNumber;
	private float employeeSalary;
	private String employeeDesignation;
	private String username;
	private String password;
	

}
