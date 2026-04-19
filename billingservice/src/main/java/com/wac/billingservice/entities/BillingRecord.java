package com.wac.billingservice.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BillingRecord {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long activationId;

    private String simNumber;

    private String phoneNumber;

    private String activationType; // IMMEDIATE, SCHEDULED

    private BigDecimal amount;

    private String status; // SUCCESS, FAILED

    private LocalDateTime billedAt;

    private String remarks;

	public BillingRecord(Long id, Long activationId, String simNumber, String phoneNumber, String activationType,
			BigDecimal amount, String status, LocalDateTime billedAt, String remarks) {
		super();
		this.id = id;
		this.activationId = activationId;
		this.simNumber = simNumber;
		this.phoneNumber = phoneNumber;
		this.activationType = activationType;
		this.amount = amount;
		this.status = status;
		this.billedAt = billedAt;
		this.remarks = remarks;
	}

	public BillingRecord() {
		// TODO Auto-generated constructor stub
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

	public String getActivationType() {
		return activationType;
	}

	public void setActivationType(String activationType) {
		this.activationType = activationType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getBilledAt() {
		return billedAt;
	}

	public void setBilledAt(LocalDateTime billedAt) {
		this.billedAt = billedAt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    
    
    
}
