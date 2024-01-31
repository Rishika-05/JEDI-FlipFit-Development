/**
 * This exception is thrown when a gym already exists in the system.
 */
package com.flipkart.exception;

/**
 * This exception is thrown when a gym already exists in the system.
 */
public class GymAlreadyExistsException extends Exception {
    public GymAlreadyExistsException() {
        super("Gym already exists");
    }
}
