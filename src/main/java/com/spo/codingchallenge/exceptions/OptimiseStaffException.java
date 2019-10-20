package com.spo.codingchallenge.exceptions;

/**
 * Custom un-checked exception to handle errors while executing optimise staff.
 * @author ex1
 *
 */

public class OptimiseStaffException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8316045483210846452L;

	public OptimiseStaffException(String message, Throwable cause) {
			super(message, cause);			
		}	
}