package com.flipkart.exception;

import java.io.InvalidObjectException;
import java.util.InvalidPropertiesFormatException;

public class InvalidChoiceException extends InvalidObjectException {
  public InvalidChoiceException(){
    super("Please Enter Valid Choice!!");
  }
}

