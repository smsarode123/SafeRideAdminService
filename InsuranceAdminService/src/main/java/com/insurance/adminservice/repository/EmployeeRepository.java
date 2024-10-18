package com.insurance.adminservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.adminservice.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	 Optional<Employee>  findByUsernameAndPassword(String username, String password);
 
}
