package com.insurance.adminservice.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceCenterId;
	private String serviceCenterName;
	private String serviceCenterAddress;
	private long serviceCenterContactNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<AccountDetail> accountDetails;
	

}
