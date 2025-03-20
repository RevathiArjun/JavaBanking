package com.task.bank.service;

import java.util.List;

import com.task.bank.response.dto.DebitCardEligibilityResponseDTO;

public interface DebitCardEligibilityService {
	
	List<DebitCardEligibilityResponseDTO> getAllDebitCardEligibility();
	DebitCardEligibilityResponseDTO getDebitCardEligibilityByCardType(String cardType);
}
