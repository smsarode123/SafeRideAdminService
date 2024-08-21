package com.insurance.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private String accountHolderName;
	private String accountHolderAddress;
	private String accountType;
	private long accountNumber;
	private String accountIfscNumber;
	
	

}
