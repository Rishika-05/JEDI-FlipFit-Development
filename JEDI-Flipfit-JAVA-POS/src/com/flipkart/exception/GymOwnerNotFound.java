package com.flipkart.exception;

public class GymOwnerNotFound extends RuntimeException {
  public GymOwnerNotFound(String gymOwnerId){
    super("Gym Centre" + gymOwnerId + " not found!");
  }
}
