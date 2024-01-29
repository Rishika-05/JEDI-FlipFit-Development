/**
 * This class represents an exception that is thrown when a user is not found.
 */
package com.flipkart.exception;

/**
 * This class extends the Exception class and is used to handle the exception when a user is not found.
 */
public class UserNotFoundException extends Exception{
	
  /**
   * Constructs a new UserNotFoundException with a default error message.
   */
  public UserNotFoundException(){
		super("\033[1;31mUser Not Found Please Try Again\033[0m");
  }
}
