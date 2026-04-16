package com.wac.provisioningservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wac.provisioningservice.entities.ProvisioningRecord;

public interface ProvisioningRecordRepository extends JpaRepository<ProvisioningRecord, Long> {

	 List<ProvisioningRecord> findBySimNumber(String simNumber);
	
}
