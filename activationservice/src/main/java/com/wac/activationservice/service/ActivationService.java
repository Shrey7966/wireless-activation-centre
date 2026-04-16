package com.wac.activationservice.service;

import java.time.LocalDateTime;
import java.util.List;

import com.wac.activationservice.dto.ActivationRequestDTO;
import com.wac.activationservice.entity.ActivationRequest;

public interface ActivationService {
	
	ActivationRequest createImmediateActivation(ActivationRequestDTO dto);
	
	ActivationRequest scheduleActivation(ActivationRequestDTO dto);
	
	List<ActivationRequest> getPendingSchdulesActivations(LocalDateTime before);

}
