package com.wac.provisioningservice.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "provisioning_records")
public class ProvisioningRecord {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long activationId;

    private String simNumber;

    private String phoneNumber;

    private String status; // ASSIGNED, COMPLETED, FAILED

    private LocalDateTime provisionedAt;

    private String remarks;

	public ProvisioningRecord(Long id, Long activationId, String simNumber, String phoneNumber, String status,
			LocalDateTime provisionedAt, String remarks) {
		super();
		this.id = id;
		this.activationId = activationId;
		this.simNumber = simNumber;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.provisionedAt = provisionedAt;
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getProvisionedAt() {
		return provisionedAt;
	}

	public void setProvisionedAt(LocalDateTime provisionedAt) {
		this.provisionedAt = provisionedAt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ProvisioningRecord() {
		super();
	}
    
	
}
