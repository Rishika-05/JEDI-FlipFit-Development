package com.flipkart.utils;

public class Utils {

    public static String convertFirstLetterCapital(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Convert the first letter to uppercase
        char firstChar = Character.toUpperCase(input.charAt(0));

        // Convert the rest of the letters to lowercase
        String restOfString = input.substring(1).toLowerCase();

        // Concatenate the first letter and the rest of the string
        return firstChar + restOfString;
    }

}
