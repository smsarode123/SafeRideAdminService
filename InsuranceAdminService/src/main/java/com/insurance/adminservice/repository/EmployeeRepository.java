package com.insurance.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.adminservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
