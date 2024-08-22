package com.insurance.adminservice.servicei;

import com.insurance.adminservice.model.ServiceCenter;

public interface ServiceCenterService {

	ServiceCenter saveServiceCenter(ServiceCenter serviceCenter);

	void removeServiceCenterById(int serviceCenterId);

	ServiceCenter UpdateServiceCenterDataById(ServiceCenter service, int servicecenterId);

}
