package com.hospital.Exception;

public class NoPatientFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public NoPatientFoundException(String message) {
        super(message);
    }
}