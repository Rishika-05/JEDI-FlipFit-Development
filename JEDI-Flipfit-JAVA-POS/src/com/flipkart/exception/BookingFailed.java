package com.flipkart.exception;

public class BookingFailed extends RuntimeException{
      public BookingFailed(String message){
        super("Error caused in Booking!!!");
      }
  }

