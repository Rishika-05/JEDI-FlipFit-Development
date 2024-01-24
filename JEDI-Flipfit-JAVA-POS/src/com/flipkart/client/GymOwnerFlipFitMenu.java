/**
 *
 */
package com.flipkart.client;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 */
public class GymOwnerFlipFitMenu {

    public void displayGymOwnerMenu() {
        int menuOption;
        do {
            System.out.println("\n\n ----------- Gym Owner Menu Options ---------- " + 
        "\nPress 1. Add a new gym Centre" +
        "\nPress 2. View Registered Gyms" +
        "\nPress 3. Remove Gym" +
        "\nPress 4. Modify Gym" +
        "\nPress 5. Register Slots " + 
        "\nPress 6. Modify Slots " + 
        "\nPress 7. View Slots " +  
        "\nPress 8. Remove Slots " +  
        "\nPress 9. View Profile" +
        "\nPress 10. Update Profile" +
        "\nPress 11. Quit \n");
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
                    modifySlots();
                    break;
                case 5:
                    viewSlots();
                    break;
                case 6:
                    viewProfile();
                    break;
                case 7:
                    updateProfile();
                    break;
                case 8:
                    viewProfile();
                    break;
                case 9:
                    viewProfile();
                    break;
                case 10:
                    viewProfile();
                    break;
                case 11:
                	System.out.println("\033[1mYou have exited the Gym Owner menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 11);

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

    private void modifySlots() {
        // Implement logic to modify the slots
    }
	  private void viewSlots() {
	        // Implement logic to view the slots
	    }
	
	  private void viewProfile() {
	    // Implement logic to view the profile of the Gym Owner
	  }
	  private void updateProfile() {
	    // Implement logic to update the profile of the Gym Owner
	  }
	
	  public static void main(String[] args){
	        GymOwnerFlipFitMenu owner = new GymOwnerFlipFitMenu();
	        owner.displayGymOwnerMenu();
	    }

}
