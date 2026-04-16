package com.wac.activationservice.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class ActivationRequestDTO {
	
	@NotBlank
	private String simNumber;
	
	private String phoneNumber;
	
	private LocalDateTime scheduledAt;

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

	public LocalDateTime getScheduledAt() {
		return scheduledAt;
	}

	public void setScheduledAt(LocalDateTime scheduledAt) {
		this.scheduledAt = scheduledAt;
	}

	public ActivationRequestDTO(@NotBlank String simNumber, String phoneNumber, LocalDateTime scheduledAt) {
		super();
		this.simNumber = simNumber;
		this.phoneNumber = phoneNumber;
		this.scheduledAt = scheduledAt;
	}

	public ActivationRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
