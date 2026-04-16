package com.wac.provisioningservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wac.provisioningservice.dto.ProvisioningRequestDto;
import com.wac.provisioningservice.entities.ProvisioningRecord;
import com.wac.provisioningservice.service.ProvisioningService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/provisioning")
public class ProvisioningController {
	
	private final ProvisioningService provisioningService;

    public ProvisioningController(ProvisioningService provisioningService) {
        this.provisioningService = provisioningService;
    }
    
    @PostMapping("/process")
    public ResponseEntity<ProvisioningRecord> processProvisioing(
    		@Valid @RequestBody ProvisioningRequestDto dto){
    	ProvisioningRecord record = provisioningService.provisionSim(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }
	

}
