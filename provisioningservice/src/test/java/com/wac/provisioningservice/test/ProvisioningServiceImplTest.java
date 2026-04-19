package com.wac.provisioningservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wac.provisioningservice.dto.ProvisioningRequestDto;
import com.wac.provisioningservice.entities.ProvisioningRecord;
import com.wac.provisioningservice.repository.ProvisioningRecordRepository;
import com.wac.provisioningservice.serviceimpl.ProvisioningServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProvisioningServiceImplTest {
	
	@Mock
    private ProvisioningRecordRepository repository;
	
	@InjectMocks
    private ProvisioningServiceImpl provisioningService;
	
	@Test
    void testProvisionSim_Success() {

        ProvisioningRequestDto dto = new ProvisioningRequestDto();
        dto.setActivationId(101L);
        dto.setSimNumber("SIM12345");
        dto.setActivationType("IMMEDIATE");

        when(repository.save(any(ProvisioningRecord.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ProvisioningRecord result = provisioningService.provisionSim(dto);

        assertEquals("SIM12345", result.getSimNumber());
        assertEquals("COMPLETED", result.getStatus());
        verify(repository, times(1)).save(any(ProvisioningRecord.class));
    }

}
