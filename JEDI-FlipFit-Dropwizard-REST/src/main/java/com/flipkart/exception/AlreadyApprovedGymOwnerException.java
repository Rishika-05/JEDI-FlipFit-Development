/**
 * This exception is thrown when a gym owner has already been approved.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when a gym owner has already been approved.
 */
public class AlreadyApprovedGymOwnerException extends Exception {
	private static final long serialVersionUID = -4343720315910996557L;

	/**
	 * Constructs a new AlreadyApprovedGymOwnerException with a default error message.
	 */
	public AlreadyApprovedGymOwnerException() {
		super("Gym owner has been already approved.");
	}
}
