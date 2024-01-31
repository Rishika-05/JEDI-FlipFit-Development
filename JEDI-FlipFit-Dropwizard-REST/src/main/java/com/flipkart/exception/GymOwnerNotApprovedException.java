/**
 * This exception is thrown when a gym owner is not approved.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when a gym owner is not approved.
 */
public class GymOwnerNotApprovedException extends Exception{
	/**
	 * Constructs a new GymOwnerNotApprovedException with a default error message.
	 */
	public GymOwnerNotApprovedException() {
		super("Gym Owner is not approved !!");
	}
}
