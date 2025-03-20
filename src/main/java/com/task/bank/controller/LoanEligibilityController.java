package com.task.bank.controller;

import com.task.bank.response.dto.LoanEligibilityResponseDTO;
import com.task.bank.service.impl.LoanEligibilityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/loaneligibility")
@AllArgsConstructor
public class LoanEligibilityController {

    
    private final  LoanEligibilityServiceImpl loanEligibilityServiceimpl;

    // End point to get all loan eligibility records
    @GetMapping("/")
    public ResponseEntity<List<LoanEligibilityResponseDTO>> getAllLoanEligibility() {
        List<LoanEligibilityResponseDTO> loanEligibilityList = loanEligibilityServiceimpl.getAllLoanEligibility();
        return new ResponseEntity<>(loanEligibilityList, HttpStatus.OK);
    }

    // End point to get loan eligibility by loan type
    @GetMapping("/type/{loanType}")
    public LoanEligibilityResponseDTO getLoanEligibilityByLoanType(@PathVariable String loanType) {
       LoanEligibilityResponseDTO loanEligibilityOptional = loanEligibilityServiceimpl.getLoanEligibilityByLoanType(loanType);

       return loanEligibilityOptional;
       
       
    }

    
    
    
    
    
}