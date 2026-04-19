package com.wac.billingservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BillingEventDTO {

	private Long billingId;
	private Long activationId;
	private String simNumber;
	private BigDecimal amount;
	private LocalDateTime billedAt;

	public BillingEventDTO(Long billingId, Long activationId, String simNumber, BigDecimal amount,
			LocalDateTime billedAt) {
		super();
		this.billingId = billingId;
		this.activationId = activationId;
		this.simNumber = simNumber;
		this.amount = amount;
		this.billedAt = billedAt;
	}

	public Long getBillingId() {
		return billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getBilledAt() {
		return billedAt;
	}

	public void setBilledAt(LocalDateTime billedAt) {
		this.billedAt = billedAt;
	}

}
