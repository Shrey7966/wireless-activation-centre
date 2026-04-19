package com.wac.billingservice.serviveimpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.wac.billingservice.dto.BillingEventDTO;
import com.wac.billingservice.dto.BillingRequestDto;
import com.wac.billingservice.entities.BillingRecord;
import com.wac.billingservice.exception.InvalidBillingException;
import com.wac.billingservice.repository.BillingRecordRepository;
import com.wac.billingservice.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {
	
	private final BillingRecordRepository repository;
	

	public BillingServiceImpl(BillingRecordRepository repository ) {
		this.repository = repository;
		
	}

	@Override
	public BillingRecord billForActivation(BillingRequestDto dto) {
		BigDecimal amount = calculateAmount(dto.getActivationType());

        BillingRecord record = new BillingRecord();
        record.setActivationId(dto.getActivationId());
        record.setSimNumber(dto.getSimNumber());
        record.setPhoneNumber(dto.getPhoneNumber());
        record.setActivationType(dto.getActivationType());
        record.setAmount(amount);
        record.setStatus("SUCCESS");
        record.setBilledAt(LocalDateTime.now());
        record.setRemarks("Billing successful");

        BillingRecord saved = repository.save(record);
        BillingEventDTO event = new BillingEventDTO(
        	    saved.getId(),
        	    saved.getActivationId(),
        	    saved.getSimNumber(),
        	    saved.getAmount(),
        	    saved.getBilledAt()
        	);
        

        
        return saved;
	}
	
	 private BigDecimal calculateAmount(String activationType) {
	        if ("IMMEDIATE".equalsIgnoreCase(activationType)) {
	            return BigDecimal.valueOf(10.00);
	        } else if ("SCHEDULED".equalsIgnoreCase(activationType)) {
	            return BigDecimal.valueOf(8.00);
	        } else {
	            throw new InvalidBillingException("Unknown activation type: " + activationType);
	        }
	    }
	 
	 


}
