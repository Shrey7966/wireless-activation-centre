package com.wac.billingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wac.billingservice.entities.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

	List<BillingRecord> findBySimNumber(String simNumber);

    List<BillingRecord> findByActivationId(Long activationId);
}
