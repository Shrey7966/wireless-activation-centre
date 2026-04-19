package com.wac.billingservice.service;

import com.wac.billingservice.dto.BillingRequestDto;
import com.wac.billingservice.entities.BillingRecord;

public interface BillingService {
	
	BillingRecord billForActivation(BillingRequestDto dto);

}
