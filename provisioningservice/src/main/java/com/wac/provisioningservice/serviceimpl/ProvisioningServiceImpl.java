package com.wac.provisioningservice.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wac.provisioningservice.dto.BillingRequestDto;
import com.wac.provisioningservice.dto.ProvisioningRequestDto;
import com.wac.provisioningservice.entities.ProvisioningRecord;
import com.wac.provisioningservice.exception.InvalidSimException;
import com.wac.provisioningservice.repository.ProvisioningRecordRepository;
import com.wac.provisioningservice.service.ProvisioningService;

@Service
public class ProvisioningServiceImpl implements ProvisioningService {

	private final ProvisioningRecordRepository repository;
	
	private final RestTemplate restTemplate;
	

	public ProvisioningServiceImpl(ProvisioningRecordRepository repository) {
		super();
		this.repository = repository;
		this.restTemplate = new RestTemplate();
	}

	@Override
	public ProvisioningRecord provisionSim(ProvisioningRequestDto dto) {
		
		if(dto.getSimNumber().length()<5) {
			throw new InvalidSimException("SIM Number is invalid");
		}
		
		String phoneNumber = generatePhoneNumber();
		
		// 3. Create provisioning record
        ProvisioningRecord record = new ProvisioningRecord();
        record.setActivationId(dto.getActivationId());
        record.setSimNumber(dto.getSimNumber());
        record.setPhoneNumber(phoneNumber);
        record.setStatus("COMPLETED");
        record.setProvisionedAt(LocalDateTime.now());
        record.setRemarks("Provisioning successful");

        ProvisioningRecord saved = repository.save(record);
        //call Billing service
        callBillingService(saved, dto.getActivationType());
		
		return saved;
	}
	

	private String generatePhoneNumber() {
		 return "98765" + (int)(Math.random() * 10000);
	}
	
	private void callBillingService(ProvisioningRecord record,String activationType) {
		
		BillingRequestDto dto = new BillingRequestDto();
		
	    dto.setActivationId(record.getActivationId());
	    dto.setSimNumber(record.getSimNumber());
	    dto.setPhoneNumber(record.getPhoneNumber());
	    dto.setActivationType(activationType);

	    try {
	        restTemplate.postForEntity(
	                "http://localhost:8083/api/billing/activation",
	                dto,
	                Void.class
	        );
	    } catch (Exception e) {
	        record.setStatus("FAILED");
	        record.setRemarks("Billing failed: " + e.getMessage());
	        repository.save(record);
	        throw new RuntimeException("Billing service unavailable");
	    }
		
    }
	

}
