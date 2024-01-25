package com.flipkart.exception;

public class GymOwnerNotFoundException extends RuntimeException {
  public GymOwnerNotFoundException(String gymOwnerId){
    super("Gym Centre" + gymOwnerId + " not found!");
  }
}
