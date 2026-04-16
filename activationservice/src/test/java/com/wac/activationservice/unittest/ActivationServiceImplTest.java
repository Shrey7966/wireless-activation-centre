package com.wac.activationservice.unittest;

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

import com.wac.activationservice.dto.ActivationRequestDTO;
import com.wac.activationservice.entity.ActivationRequest;
import com.wac.activationservice.repository.ActivationRequestRepository;
import com.wac.activationservice.service.impl.ActivationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ActivationServiceImplTest {
	
	@Mock
    private ActivationRequestRepository repository;

    @InjectMocks
    private ActivationServiceImpl activationService;

    @Test
    void testCreateImmediateActivation() {
    	ActivationRequestDTO dto = new ActivationRequestDTO();
        dto.setSimNumber("SIM123");
        dto.setPhoneNumber("1234567890");

        when(repository.save(any(ActivationRequest.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ActivationRequest result = activationService.createImmediateActivation(dto);

        assertEquals("SIM123", result.getSimNumber());
        assertEquals("PENDING", result.getStatus());
        verify(repository, times(1)).save(any(ActivationRequest.class));
    }
	

}
