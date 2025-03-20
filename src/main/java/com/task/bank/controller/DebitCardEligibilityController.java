package com.task.bank.controller;

import com.task.bank.response.dto.DebitCardEligibilityResponseDTO;
import com.task.bank.service.DebitCardEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debit-card-eligibility")
public class DebitCardEligibilityController {

    private final DebitCardEligibilityService debitCardEligibilityService;

    // Constructor-based injection of service class
    @Autowired
    public DebitCardEligibilityController(DebitCardEligibilityService debitCardEligibilityService) {
        this.debitCardEligibilityService = debitCardEligibilityService;
    }

    // Endpoint to get all debit card eligibility records
    @GetMapping
    public ResponseEntity<List<DebitCardEligibilityResponseDTO>> getAllDebitCardEligibility() {
        List<DebitCardEligibilityResponseDTO> eligibilityList = debitCardEligibilityService.getAllDebitCardEligibility();
        return ResponseEntity.ok(eligibilityList);  // Return 200 OK with the list
    }

    // Endpoint to get a specific debit card eligibility by card type
    @GetMapping("/{cardType}")
    public ResponseEntity<DebitCardEligibilityResponseDTO> getDebitCardEligibilityByCardType(@PathVariable String cardType) {
        DebitCardEligibilityResponseDTO eligibility = debitCardEligibilityService.getDebitCardEligibilityByCardType(cardType);
        return ResponseEntity.ok(eligibility);  // Return 200 OK with the specific eligibility
    }
}
