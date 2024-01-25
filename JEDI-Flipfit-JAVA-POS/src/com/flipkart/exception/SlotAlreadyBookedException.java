package com.flipkart.exception;

public class SlotAlreadyBookedException extends Exception{
  public SlotAlreadyBookedException() {
    super("This slot is already booked!!");
  }
}