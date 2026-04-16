package com.wac.provisioningservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProvisioningRequestDto {
	
	@NotNull
    private Long activationId;

    @NotBlank
    private String simNumber;

    private String activationType; // IMMEDIATE or SCHEDULED

	public ProvisioningRequestDto(@NotNull Long activationId, @NotBlank String simNumber, String activationType) {
		super();
		this.activationId = activationId;
		this.simNumber = simNumber;
		this.activationType = activationType;
	}

	public ProvisioningRequestDto() {
		// TODO Auto-generated constructor stub
	}

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

	public String getActivationType() {
		return activationType;
	}

	public void setActivationType(String activationType) {
		this.activationType = activationType;
	}
    
}
