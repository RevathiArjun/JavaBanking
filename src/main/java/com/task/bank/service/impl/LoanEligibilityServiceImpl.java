package com.task.bank.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.task.bank.Exception.LoanEligibilityNotFoundException;
import com.task.bank.entity.LoanEligibility;
import com.task.bank.repository.LoanEligibilityRepository;
import com.task.bank.response.dto.LoanEligibilityResponseDTO;
import com.task.bank.service.LoanEligibilityService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanEligibilityServiceImpl implements LoanEligibilityService {
	
	
    private final ModelMapper modelMapper;  // Inject ModelMapper	
    private final LoanEligibilityRepository loanEligibilityRepository;

    // Method to get all loan eligibility records as DTOs
    public List<LoanEligibilityResponseDTO> getAllLoanEligibility() {
        List<LoanEligibility> loanEligibilities = loanEligibilityRepository.findAll();
        if (loanEligibilities.isEmpty()) {
            // Optionally, log or handle the empty list case
            throw new LoanEligibilityNotFoundException("No loan eligibility records found.");
        }
        
        return loanEligibilities.stream()
                .map(loan -> modelMapper.map(loan, LoanEligibilityResponseDTO.class))  // Use ModelMapper for mapping
                .collect(Collectors.toList());
    
    }

    // Method to get loan eligibility by Loan Type
    public LoanEligibilityResponseDTO getLoanEligibilityByLoanType(String loanType) {
        return loanEligibilityRepository.findByLoanType(loanType)
        		 .map(loan -> modelMapper.map(loan, LoanEligibilityResponseDTO.class))  // Mapping entity to DTO
                 .orElseThrow(() -> new LoanEligibilityNotFoundException("Loan eligibility not found for loan type: " + loanType));  // Or throw exception if not found
    }
}
