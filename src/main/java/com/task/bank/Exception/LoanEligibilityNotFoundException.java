package com.task.bank.Exception;

public class LoanEligibilityNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6574882295202656193L;

	public LoanEligibilityNotFoundException(String message) {
        super(message);
    }
}
