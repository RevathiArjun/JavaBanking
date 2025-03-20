package com.task.bank.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DebitCardEligibilityResponseDTO {
	
    private String cardType;
    private String eligibilityCriteria;
    
    @Override
    public String toString() {
        return "DebitCardEligibilityResponseDTO{" +
               ", cardType='" + cardType + '\'' +
               ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
               '}';
    }

}
