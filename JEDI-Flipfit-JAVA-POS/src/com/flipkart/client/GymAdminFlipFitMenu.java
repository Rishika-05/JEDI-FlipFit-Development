/**
 *
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymFlipFitServiceImpl;

/**
 *
 */
public class GymAdminFlipFitMenu {
	GymCustomerFlipFitService customerService = GymCustomerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	
    public void displayAdminMenu() {
        int menuOption;
        do {
            System.out.println("\n\n ------ Gym Admin Menu Options ------ " +
				 "\nPress 1. Browse Gym Registrations" +
//				 "\nPress 2. Create Owner Login Details " +
				 "\nPress 3. Browse Slot Registrations " +
//				 "\nPress 4. Verify Payments " + 
				 "\nPress 5. Browse Owner Registrations " + 
				 "\nPress 6. Browse Gyms" + 
				 "\nPress 7. Exit");
            Scanner in = new Scanner(System.in);
            menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                    browseGymRegistrations();
                    break;
//                case 2:
//                    createLoginDetails();
//                    break;
                case 3:
                    browseSlotRegistrations();
                    break;
//                case 4:
//                    verifyPayments();
//                    break;
                case 5:
                    browseOwnerRegistrations();
                    break;
                case 6:
                    browseGyms();
                    break;
                case 7:
                    System.out.println("\033[1mYou have exited the Gym Admin menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 7);
    }

    private void browseGyms() {
    	System.out.println("\033[1m\nGymID\tGymName\t\tLocation\033[0m");
		System.out.println("-----------------------------------------------------------");
		gymService.addGym(null);
		gymService.viewAllGyms().forEach(gym -> System.out.println(gym.getGymId() + "\t" + gym.getGymName() + "\t\t"
					+ gym.getLocation()));
		
	}

	private void browseGymRegistrations() {
        // Implement logic to browse gym registrations
    }


    private void createLoginDetails() {
        // Implement logic to create login details
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
