 package com.flipkart.exception;

public class UserNotFoundException extends Exception{
	
  public UserNotFoundException(){
		super("\033[1;31mUser Not Found Please Try Again\033[0m");
  }
}
