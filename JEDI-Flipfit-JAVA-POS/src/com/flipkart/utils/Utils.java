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

    public static void printFormattedTableHeader(String format, String... headers) {
        // Calculate the total length of the line based on the format and headers
        int totalLength = String.format(format, (Object[]) headers).length();

        // Print the line with dashes
        System.out.println("━".repeat(totalLength));

        // Print the formatted header
        System.out.printf(format, (Object[]) headers);

        // Print an extra line with dashes for separation
        System.out.println("\n" + "━".repeat(totalLength));
    }

    public static void printFormattedTableRow(String format, Object... values) {
        // Convert values to strings with proper formatting
        String[] formattedValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            formattedValues[i] = formatValue(values[i]);
        }


        // Print the formatted row
        System.out.printf(format, (Object[]) formattedValues);

        // Print an extra line with dashes for separation
        System.out.println("\n" + "━".repeat(String.format(format, (Object[]) formattedValues).length()));
        System.out.println();
    }

    // Helper method to format values as strings
    private static String formatValue(Object value) {
        return String.format("%s", value);
    }

    public static void displayLogoUtil(String windowTitle) {


        System.out.println("\033[1;34m      ▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▖\033[0m " + windowTitle + " \033[1;34m▝▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞\033[0m");
        System.out.println("");

    }








}
