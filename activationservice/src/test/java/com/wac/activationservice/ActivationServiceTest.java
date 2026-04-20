package com.wac.activationservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.wac.activationservice.dto.ActivationRequestDTO;
import com.wac.activationservice.entity.ActivationRequest;
import com.wac.activationservice.repository.ActivationRequestRepository;
import com.wac.activationservice.service.impl.ActivationServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ActivationServiceTest {
	
	@Mock
	ActivationRequestRepository repo;
	
	
	@InjectMocks
	ActivationServiceImpl serviceIMPL;
	
	ActivationRequestDTO req;
	
	 @BeforeEach
	    void setUp() {
	        req = new ActivationRequestDTO();
	        req.setPhoneNumber("123456789");
	        req.setSimNumber("SIM23456");
	        req.setScheduledAt(LocalDateTime.now().plusHours(2));
	    }
	
	
	
	@Test
	public void test_scheduleActivation()
	{
		
		ActivationRequest savedRequest = new ActivationRequest();
		savedRequest.setPhoneNumber(req.getPhoneNumber());
		savedRequest.setSimNumber(req.getSimNumber());
		savedRequest.setScheduledAt(req.getScheduledAt());
		
		when(repo.save(any(ActivationRequest.class))).thenReturn(savedRequest);
		
		ActivationRequest scheduleActivation = serviceIMPL.scheduleActivation(req);
		
		assertNotNull(scheduleActivation);
		assertEquals("123456789", scheduleActivation.getPhoneNumber());
		
		
		
	}
	
	

}
