package com.wac.provisioningservice.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wac.provisioningservice.repository.ProvisioningRecordRepository;
import com.wac.provisioningservice.serviceimpl.ProvisioningServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProvisioningServiceImplTest {
	
	@Mock
    private ProvisioningRecordRepository repository;
	
	@InjectMocks
    private ProvisioningServiceImpl provisioningService;

}
