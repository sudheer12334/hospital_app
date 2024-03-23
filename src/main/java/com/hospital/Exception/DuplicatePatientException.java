package com.hospital.Exception;

public class DuplicatePatientException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public DuplicatePatientException(String message) {
        super(message);
    }
}