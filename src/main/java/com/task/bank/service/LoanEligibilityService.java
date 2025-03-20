package com.task.bank.service;

import java.util.List;

import com.task.bank.response.dto.LoanEligibilityResponseDTO;

public interface LoanEligibilityService {

    // Method to get all loan eligibility records as DTOs
    List<LoanEligibilityResponseDTO> getAllLoanEligibility();

    // Method to get loan eligibility by Loan Type
    LoanEligibilityResponseDTO getLoanEligibilityByLoanType(String loanType);
}
