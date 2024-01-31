/**
 * The SlotNotAvailableException class represents an exception that is thrown when a slot is not available.
 * This exception is typically used in the context of a booking system where slots can be reserved or occupied.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when a slot is not available.
 */
public class SlotNotAvailableException extends Exception {
    /**
     * Constructs a new SlotNotAvailableException with a default error message.
     */
    public SlotNotAvailableException() {
        super("Slot not available");
    }
}
