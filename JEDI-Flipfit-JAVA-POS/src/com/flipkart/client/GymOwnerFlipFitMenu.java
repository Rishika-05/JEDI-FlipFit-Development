/**
 * 
 */
package com.flipkart.client;
import java.util.ArrayList;
import com.flipkart.bean.User;
import java.util.Scanner;
/**
 * 
 */
public class GymOwnerFlipFitMenu {




    public void displayMenu(Scanner in) {
        int menuOption = 1;
        do {
            System.out.println("\n\n ------ Gym Customer Menu Options ------ " + "\nPress 1. Browse Gyms"
                    + "\nPress 2. View Gym Details " + "\nPress 3. Book a Slot " + "\nPress 4. Cancel Booking "
                    + "\nPress 5. View Booking History " + "\nPress 6. Browse Waitlist " + "\nPress 7. Modify Booking "
                    + "\nPress 8. View Plan based on Day " + "\nPress 9. Cancel Waitlist " + "\nPress 10. Payment "
                    + "\nPress 11. Exit");
            menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                    browseGyms();
                    break;
                case 2:
                    viewGymDetails();
                    break;
                case 3:
                    bookSlot();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    viewBookingHistory();
                    break;
                case 6:
                    browseWaitlist();
                    break;
                case 7:
                    modifyBooking();
                    break;
                case 8:
                    viewPlanBasedOnDay();
                    break;
                case 9:
                    cancelWaitlist();
                    break;
                case 10:
                    payment();
                    break;
                case 11:
                    System.out.println("\033[1mYou have exited the Gym Customer menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 11);
    }



    private void browseGyms() {
        // Implement logic to browse available gyms
    }

    private void viewGymDetails() {
        // Implement logic to view details of a specific gym
    }

    private void bookSlot() {
        // Implement logic to allow the customer to book a slot
    }

    private void cancelBooking() {
        // Implement logic to cancel a booked slot
    }

    private void viewBookingHistory() {
        // Implement logic to view the booking history
    }

    private void browseWaitlist() {
        // Implement logic to browse the waitlist
    }

    private void modifyBooking() {
        // Implement logic to modify a booked slot
    }

    private void viewPlanBasedOnDay() {
        // Implement logic to view the plan based on the day
    }

    private void cancelWaitlist() {
        // Implement logic to cancel a waitlist entry
    }

    private void payment() {
        // Implement logic for payment
    }

}
