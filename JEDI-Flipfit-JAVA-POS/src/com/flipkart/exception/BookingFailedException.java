/**
 * This exception is thrown when a booking fails in the FlipFit application.
 * It is a subclass of the Exception class.
 */
package com.flipkart.exception;

public class BookingFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookingFailedException(String message){
        super(message);
    }
}
