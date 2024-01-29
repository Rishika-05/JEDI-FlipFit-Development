/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 */
public class BookingExistsException extends Exception {
    private static final long serialVersionUID = 8058325492641231448L;

	public BookingExistsException() {
    	super("Booking already exists");
    }
}
