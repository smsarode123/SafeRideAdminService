package com.insurance.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.adminservice.model.ServiceCenter;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Integer> {

}
