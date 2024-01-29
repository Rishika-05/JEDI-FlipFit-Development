/**
 * This exception is thrown when a gym owner already exists in the system.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when a gym owner already exists in the system.
 */
public class GymOwnerAlreadyExistsException extends Exception {
    public GymOwnerAlreadyExistsException() {
        super("Gym owner already exists");
    }
}
