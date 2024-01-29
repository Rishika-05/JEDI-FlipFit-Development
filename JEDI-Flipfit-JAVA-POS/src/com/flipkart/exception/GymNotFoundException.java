/**
 * This exception is thrown when gyms are not found.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when gyms are not found.
 */
public class GymNotFoundException extends Exception {
	/**
	 * Constructs a new GymNotFoundException with a default error message.
	 */
	public GymNotFoundException() {
		super("Gyms not found !!");
	}
}