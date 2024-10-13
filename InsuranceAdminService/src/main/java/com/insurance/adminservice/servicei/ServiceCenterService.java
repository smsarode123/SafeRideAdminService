package com.insurance.adminservice.servicei;

import java.util.List;

import com.insurance.adminservice.model.ServiceCenter;

public interface ServiceCenterService {

	ServiceCenter saveServiceCenter(ServiceCenter serviceCenter);

	void removeServiceCenterById(int serviceCenterId);

	ServiceCenter UpdateServiceCenterDataById(ServiceCenter service, int servicecenterId);

	List<ServiceCenter> getAllServiceCenter();

	ServiceCenter getSingleServiceCenterById(int serviceCenterId);
 
}
