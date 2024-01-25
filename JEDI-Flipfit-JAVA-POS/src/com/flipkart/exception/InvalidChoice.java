package com.flipkart.exception;

import java.io.InvalidObjectException;

public class InvalidChoice extends InvalidObjectException {
  public InvalidChoice(){
    super("Please Enter Valid Choice!!");
  }
}

