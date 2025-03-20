package com.task.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.DebitCardEligibility;

@Repository
public interface DebitCardEligibilityRepository extends JpaRepository<DebitCardEligibility, Integer> {
    // Custom query methods can be defined here if needed.
	Optional<DebitCardEligibility> findByCardType(String cardtype);
}
