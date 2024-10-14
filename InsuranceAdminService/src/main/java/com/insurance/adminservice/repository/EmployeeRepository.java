package com.insurance.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.adminservice.model.Employee;
import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	 Optional<Employee>  findByUsernameAndPassword(String username, String password);
 
}
