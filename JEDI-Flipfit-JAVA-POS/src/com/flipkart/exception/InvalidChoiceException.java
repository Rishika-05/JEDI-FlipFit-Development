/**
 * 
 */
package com.flipkart.exception;

import java.io.InvalidObjectException;

/**
 * 
 */
public class InvalidChoiceException extends InvalidObjectException {
    public InvalidChoiceException(){
        super("Please enter valid choice");
    }
}
