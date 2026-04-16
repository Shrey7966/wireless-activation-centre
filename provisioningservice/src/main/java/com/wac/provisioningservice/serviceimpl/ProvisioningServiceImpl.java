package com.wac.provisioningservice.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.wac.provisioningservice.dto.ProvisioningRequestDto;
import com.wac.provisioningservice.entities.ProvisioningRecord;
import com.wac.provisioningservice.exception.InvalidSimException;
import com.wac.provisioningservice.repository.ProvisioningRecordRepository;
import com.wac.provisioningservice.service.ProvisioningService;

@Service
public class ProvisioningServiceImpl implements ProvisioningService {

	private final ProvisioningRecordRepository repository;

	public ProvisioningServiceImpl(ProvisioningRecordRepository repository) {
		super();
		this.repository = repository;
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
		
		return saved;
	}
	

	private String generatePhoneNumber() {
		 return "98765" + (int)(Math.random() * 10000);
	}
	
	private void callBillingService(ProvisioningRecord record) {
		
    }
	

}
