package com.wac.activationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wac.activationservice.dto.ActivationRequestDTO;
import com.wac.activationservice.entity.ActivationRequest;
import com.wac.activationservice.service.ActivationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/activations")
public class ActivationController {
	
	private final ActivationService service;

	public ActivationController(ActivationService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/immediate")
	public ResponseEntity <ActivationRequest> createImmediateAction(
			@Valid @RequestBody ActivationRequestDTO dto){
		ActivationRequest created = service.createImmediateActivation(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PostMapping("/schedule")
	public ResponseEntity <ActivationRequest> schduleActivation(
			@Valid @RequestBody ActivationRequestDTO dto){
		ActivationRequest created = service.createImmediateActivation(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
		
	}
	
	
	
	
	

}
