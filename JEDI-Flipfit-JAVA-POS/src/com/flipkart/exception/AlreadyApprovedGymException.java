/**
 * This exception is thrown when a gym has already been approved.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when a gym has already been approved.
 */
public class AlreadyApprovedGymException extends Exception {	
	public AlreadyApprovedGymException() {
		super("Gym has been already approved.");
	}
}
