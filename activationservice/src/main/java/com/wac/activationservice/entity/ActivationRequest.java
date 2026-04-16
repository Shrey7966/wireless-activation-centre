package com.wac.activationservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activation_requests")
public class ActivationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String simNumber;
	
	private String phoneNumber;
	
	private String status; // PENDING, SCHEDULED, COMPLETED
	
	private LocalDateTime requestAt;
	
	private LocalDateTime scheduledAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getRequestAt() {
		return requestAt;
	}

	public void setRequestAt(LocalDateTime requestAt) {
		this.requestAt = requestAt;
	}

	public LocalDateTime getScheduledAt() {
		return scheduledAt;
	}

	public void setScheduledAt(LocalDateTime scheduledAt) {
		this.scheduledAt = scheduledAt;
	}

	public ActivationRequest(Long id, String simNumber, String phoneNumber, String status, LocalDateTime requestAt,
			LocalDateTime scheduledAt) {
		super();
		this.id = id;
		this.simNumber = simNumber;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.requestAt = requestAt;
		this.scheduledAt = scheduledAt;
	}

	public ActivationRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
