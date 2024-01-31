/**
 * 
 */
package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.flipkart.exception.InvalidAadhaarException;
import com.flipkart.exception.InvalidPanCardException;

/**
 * It contains all validator function
 */
public class Validator {
	// Regular expressions for validation
    private static final String PHONE_NUMBER_REGEX = "^[0-9]{10}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    private static final String AADHAR_CARD_REGEX = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
    private static final String PAN_CARD_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
    private static final String GSTIN_REGEX = "^\\d{2}[A-Z]{5}\\d{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";

    // Phone number validation
    public static boolean validatePhoneNo(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // Email validation
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Aadhar card validation
    public static boolean validateAadharCard(String aadharCard) throws InvalidAadhaarException {
        Pattern pattern = Pattern.compile(AADHAR_CARD_REGEX);
        Matcher matcher = pattern.matcher(aadharCard);
        if (!matcher.matches()) {
            throw new InvalidAadhaarException("Invalid Aadhar card number");
        }
        return true;
    }

    // PAN card validation
    public static boolean validatePanCard(String panCard) throws InvalidPanCardException {
        Pattern pattern = Pattern.compile(PAN_CARD_REGEX);
        Matcher matcher = pattern.matcher(panCard);
        if (!matcher.matches()) {
            throw new InvalidPanCardException("Invalid PAN card number");
        }
        return true;
    }

    // GSTIN validation
    public static boolean validateGstin(String gstin) {
        Pattern pattern = Pattern.compile(GSTIN_REGEX);
        Matcher matcher = pattern.matcher(gstin);
        return matcher.matches();
    }
}
