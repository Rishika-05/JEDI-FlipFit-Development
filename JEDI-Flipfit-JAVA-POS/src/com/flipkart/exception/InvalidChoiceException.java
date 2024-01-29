
/**
 * This exception is thrown when an invalid choice is made.
 */
package com.flipkart.exception;

import java.io.InvalidObjectException;

/**
 * This exception is thrown when an invalid choice is made.
 */
public class InvalidChoiceException extends InvalidObjectException {
    public InvalidChoiceException(){
        super("Please enter valid choice");
    }
}

