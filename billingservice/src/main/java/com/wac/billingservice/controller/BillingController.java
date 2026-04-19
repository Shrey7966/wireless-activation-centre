package com.wac.billingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wac.billingservice.dto.BillingRequestDto;
import com.wac.billingservice.entities.BillingRecord;
import com.wac.billingservice.service.BillingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/activation")
    public ResponseEntity<BillingRecord> billForActivation(
            @Valid @RequestBody BillingRequestDto dto) {

        BillingRecord record = billingService.billForActivation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }
}
