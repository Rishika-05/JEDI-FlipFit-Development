/**
 * This exception is thrown when there are no available seats for a particular event.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when there are no available seats for a particular event.
 */
public class SeatsNotAvailableException extends Exception {
    public SeatsNotAvailableException() {
        super("Seats not available");
    }
}
