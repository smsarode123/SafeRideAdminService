package com.insurance.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.adminservice.model.AccountDetail;
@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetail, Integer>{

}
