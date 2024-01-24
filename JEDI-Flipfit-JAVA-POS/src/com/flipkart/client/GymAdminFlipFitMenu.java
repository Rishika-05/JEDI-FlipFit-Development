/**
 *
 */
package com.flipkart.client;

import java.util.Scanner;

/**
 *
 */
public class GymAdminFlipFitMenu {

    public void displayAdminMenu() {
        int menuOption;
        do {
            System.out.println("\n\n ------ Gym Admin Menu Options ------ " + "\nPress 1. Browse Gym Registrations"
                     + "\nPress 2. Create Owner Login Details "
                   + "\nPress 3. Browse Slot Registrations " +
                     "\nPress 4. Verify Payments " + 
                   "\nPress 5. Browse Owner Registrations " + 
                     "\nPress 6. Exit");
            Scanner in = new Scanner(System.in);
            menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                    browseGymRegistrations();
                    break;
                case 2:
                    createLoginDetails();
                    break;
                case 3:
                    browseSlotRegistrations();
                    break;
                case 4:
                    verifyPayments();
                    break;
                case 5:
                    browseOwnerRegistrations();
                    break;
                case 6:
                    System.out.println("\033[1mYou have exited the Gym Admin menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 6);
    }

    private void browseGymRegistrations() {
        // Implement logic to browse gym registrations
    }

    private void validateCredentials() {
        // Implement logic to validate credentials
    }

    private void createLoginDetails() {
        // Implement logic to create login details
    }

    private void acceptRequests() {
        // Implement logic to accept requests
    }

    private void browseSlotRegistrations() {
        // Implement logic to browse slot registrations
    }

    private void verifyPayments() {
        // Implement logic to verify payments
    }

    private void browseOwnerRegistrations() {
        // Implement logic to browse owner registrations
    }
}
