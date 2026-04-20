package com.wac.activationservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wac.activationservice.dto.ActivationRequestDTO;
import com.wac.activationservice.entity.ActivationRequest;
import com.wac.activationservice.exception.InvalidActivationException;
import com.wac.activationservice.repository.ActivationRequestRepository;
import com.wac.activationservice.service.ActivationService;

@Service
public class ActivationServiceImpl implements ActivationService {

	private final ActivationRequestRepository repo;

	public ActivationServiceImpl(ActivationRequestRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public ActivationRequest createImmediateActivation(ActivationRequestDTO dto) {

		ActivationRequest request = new ActivationRequest();

		request.setSimNumber(dto.getSimNumber());
		request.setPhoneNumber(dto.getPhoneNumber());
		request.setRequestAt(LocalDateTime.now());
		request.setStatus("PENDING");

		return repo.save(request);
	}

	@Override
	public  ActivationRequest scheduleActivation(ActivationRequestDTO dto) {
		
		if (dto.getScheduledAt().isBefore(LocalDateTime.now())) {
	        throw new InvalidActivationException("Scheduled time must be in the future");
	    }

		ActivationRequest request = new ActivationRequest();
		request.setSimNumber(dto.getSimNumber());
		request.setPhoneNumber(dto.getPhoneNumber());
		request.setRequestAt(LocalDateTime.now());
		
		// request for scheduled time
		request.setScheduledAt(dto.getScheduledAt());
		// mark the request with schduled status
		request.setStatus("SCHEDULED");
		return repo.save(request);
	}

	@Override
	public List<ActivationRequest> getPendingSchdulesActivations(LocalDateTime before) {
		return repo.findByScheduledAtBeforeAndStatus(before, "SCHEDULED");
	}
	
	
	@Scheduled(fixedRate = 60000) // every 60 seconds
	public void processScheduledActivations() {
		List<ActivationRequest> due = getPendingSchdulesActivations(LocalDateTime.now());
		
		for(ActivationRequest request : due) {
			request.setStatus("PENDING");
			repo.save(request);
		}
	}

}
