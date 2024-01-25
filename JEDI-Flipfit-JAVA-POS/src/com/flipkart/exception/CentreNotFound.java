package com.flipkart.exception;

public class CentreNotFound extends RuntimeException{
  public CentreNotFound(String gymId){
    super("Gym Centre"+gymId+ "not found!!");
  }
}
