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
	private int bankId;
	private String bankName;
	private String bankAdress;
	private String bankAccoutHolderName;
	private String bankAccountType;
	private long bankAccountNumber;
	private String bankIfscNumber;
	
	

}
