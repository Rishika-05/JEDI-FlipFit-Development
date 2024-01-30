/**
 * The BookingExistsException class is an exception that is thrown when a booking already exists.
 */
package com.flipkart.exception;

/**
 * This class represents an exception that is thrown when a booking already exists.
 */
public class BookingExistsException extends Exception {
    public BookingExistsException() {
        super("Booking already exists.");
    }
}
