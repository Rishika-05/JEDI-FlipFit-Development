/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 */
public class AlreadyApprovedGymOwnerException extends Exception {
	private static final long serialVersionUID = -4343720315910996557L;

	public AlreadyApprovedGymOwnerException() {
		super("Gym owner has been already approved.");
	}
}
