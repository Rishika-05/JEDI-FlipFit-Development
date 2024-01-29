/**
 * The InvalidPanCardException class represents an exception that is thrown when an invalid PAN card is encountered.
 * It is a subclass of the Exception class.
 */
package com.flipkart.exception;

/**
 * This class represents an exception that is thrown when an invalid PAN card is encountered.
 */
public class InvalidPanCardException extends Exception {
    /**
     * Constructs a new InvalidPanCardException with a default error message.
     */
	public InvalidPanCardException(String message) {
        super(message);
    }
}
