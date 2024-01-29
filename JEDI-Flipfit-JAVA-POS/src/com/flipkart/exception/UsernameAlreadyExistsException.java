/**
 * The UsernameAlreadyExistsException class is an exception that is thrown when a username already exists.
 * It is a subclass of the Exception class.
 */
package com.flipkart.exception;

public class UsernameAlreadyExistsException extends Exception {
	/**
	 * Constructs a new UsernameAlreadyExistsException with a default error message.
	 */
	public UsernameAlreadyExistsException() {
		super("Username already exists !!!");
	}
}
