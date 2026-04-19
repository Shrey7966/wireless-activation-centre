package com.wac.billingservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BillingRequestDto {
	
	@NotNull
    private Long activationId;

    @NotBlank
    private String simNumber;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String activationType; // IMMEDIATE or SCHEDULED

	public Long getActivationId() {
		return activationId;
	}

	public void setActivationId(Long activationId) {
		this.activationId = activationId;
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

	public String getActivationType() {
		return activationType;
	}

	public void setActivationType(String activationType) {
		this.activationType = activationType;
	}

	public BillingRequestDto(@NotNull Long activationId, @NotBlank String simNumber, @NotBlank String phoneNumber,
			@NotBlank String activationType) {
		super();
		this.activationId = activationId;
		this.simNumber = simNumber;
		this.phoneNumber = phoneNumber;
		this.activationType = activationType;
	}

    
    
}
