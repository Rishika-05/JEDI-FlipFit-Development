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

    public void displayGymOwnerMenu() {
        int menuOption;
        do {
            System.out.println("\n\n ------ Gym Owner Menu Options ------ " + "\nPress 1. Add a new gym Centre"
                    + "\nPress 2. View Registered Gyms " + "\nPress 3. Register Time Slots " + "\nPress 4. View Profile" +"\nPress 5. Quit");
            Scanner in = new Scanner(System.in);
            menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                    addNewGym();
                    break;
                case 2:
                    viewRegisteredGyms();
                    break;
                case 3:
                    registerTimeSlots();
                    break;
                case 4:
                    viewProfile();
                    break;
                case 5:
                    System.out.println("\033[1mYou have exited the Gym Owner menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 5);
    }


    private void addNewGym() {
        // Implement logic to add a new gym center
    }

    private void viewRegisteredGyms() {
        // Implement logic to view registered gyms
    }

    private void registerTimeSlots() {
        // Implement logic to register time slots for a gym
    }

    private void viewProfile() {
        // Implement logic to view the profile of the Gym Owner
    }

}
