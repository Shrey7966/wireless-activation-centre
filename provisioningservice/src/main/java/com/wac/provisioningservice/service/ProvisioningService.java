package com.wac.provisioningservice.service;

import com.wac.provisioningservice.dto.ProvisioningRequestDto;
import com.wac.provisioningservice.entities.ProvisioningRecord;


public interface ProvisioningService {
	
	ProvisioningRecord provisionSim(ProvisioningRequestDto dto);
	
}
