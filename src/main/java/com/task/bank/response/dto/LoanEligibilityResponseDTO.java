package com.task.bank.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanEligibilityResponseDTO {

    private  String loanType;
    private  String eligibilityCriteria;

 
    // Override toString for easier debugging
    @Override
    public String toString() {
        return "LoanEligibilityResponseDTO{" +
                ", loanType='" + loanType + '\'' +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                '}';
    }
}

