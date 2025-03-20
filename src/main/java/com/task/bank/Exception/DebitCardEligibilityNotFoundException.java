package com.task.bank.Exception;

public class DebitCardEligibilityNotFoundException extends RuntimeException {

    public DebitCardEligibilityNotFoundException(String cardType) {
        super("Debit card eligibility not found for card type: " + cardType);
    }
}

