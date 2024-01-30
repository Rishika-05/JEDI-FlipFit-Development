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
		super("\033[1;31mInvalid Credentials: Username or Password is wrong\033[0m");
	}
}
