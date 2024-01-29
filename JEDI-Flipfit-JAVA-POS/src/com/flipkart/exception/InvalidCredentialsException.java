/**
 * The InvalidCredentialsException class is an exception that is thrown when the provided credentials (username or password) are invalid.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when the provided credentials (username or password) are invalid.
 */
public class InvalidCredentialsException extends Exception {
	/**
	 * Constructs a new InvalidCredentialsException with a default error message.
	 */
	public InvalidCredentialsException() {
		super("Invalid Credentials: Username or Password is wrong");
	}
}
