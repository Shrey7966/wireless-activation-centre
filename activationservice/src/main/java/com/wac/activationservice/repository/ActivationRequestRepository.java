package com.wac.activationservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wac.activationservice.entity.ActivationRequest;

public interface ActivationRequestRepository extends JpaRepository<ActivationRequest, Long> {
	
	List<ActivationRequest> findByStatus(String status);
	
	List<ActivationRequest> findByScheduledAtBeforeAndStatus(LocalDateTime time, String status);
	

}
