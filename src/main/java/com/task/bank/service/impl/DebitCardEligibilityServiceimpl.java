package com.task.bank.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.task.bank.Exception.DebitCardEligibilityNotFoundException;
import com.task.bank.entity.DebitCardEligibility;
import com.task.bank.repository.DebitCardEligibilityRepository;
import com.task.bank.repository.LoanEligibilityRepository;
import com.task.bank.response.dto.DebitCardEligibilityResponseDTO;
import com.task.bank.service.DebitCardEligibilityService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class DebitCardEligibilityServiceimpl implements DebitCardEligibilityService {
	
	private  ModelMapper modelMapper;  // Inject ModelMapper
	private  DebitCardEligibilityRepository debitCardEligibilityRepository;


	@Override
	public List<DebitCardEligibilityResponseDTO> getAllDebitCardEligibility() {
List<DebitCardEligibility> debitCardEligibilities = debitCardEligibilityRepository.findAll();
        
        // Check if the list is empty and throw an exception if it is
        if (debitCardEligibilities.isEmpty()) {
            throw new DebitCardEligibilityNotFoundException("No debit card eligibility records found.");
        }

        return debitCardEligibilities.stream()
                .map(loan -> modelMapper.map(loan, DebitCardEligibilityResponseDTO.class))  // Use ModelMapper to map the entity to DTO
                .collect(Collectors.toList());
	}

	@Override
	public DebitCardEligibilityResponseDTO getDebitCardEligibilityByCardType(String cardType) {
		// TODO Auto-generated method stub
		return debitCardEligibilityRepository.findByCardType(cardType)
				 .map(loan -> modelMapper.map(loan, DebitCardEligibilityResponseDTO.class))  // Map using ModelMapper
	                .orElseThrow(() -> new DebitCardEligibilityNotFoundException(cardType));  // Return null or handle not found scenario
	}

}
