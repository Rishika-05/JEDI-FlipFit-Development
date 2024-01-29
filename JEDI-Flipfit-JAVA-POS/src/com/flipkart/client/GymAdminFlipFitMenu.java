/**
 *
 */
package com.flipkart.client;

import java.util.List;
import java.util.Scanner;
import com.flipkart.utils.Utils;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.GymOwnerFlipFitService;
import com.flipkart.service.SlotFlipFitService;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymOwnerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.SlotFlipFitServiceImpl;


public class GymAdminFlipFitMenu {
	GymCustomerFlipFitService customerService = GymCustomerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	GymOwnerFlipFitService ownerService = GymOwnerFlipFitServiceImpl.getInstance();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
    public void displayAdminMenu() {
        int menuOption;
        do {
            Utils.displayLogoUtil("Gym Admin Menu");
            System.out.println("\nPress 1. Browse Owner Registrations" +
				 "\nPress 2. Browse Gym Registrations " +
				 "\nPress 3. Browse Slot Registrations " + 
				 "\nPress 4. Browse Gyms" + 
				 "\nPress 6. Exit");
            System.out.print("\033[1mEnter Choice ► \033[0m");
            Scanner in = new Scanner(System.in);
            menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                	browseOwnerRegistrations();
                    break;
                case 2:
                    browseGymRegistrations();
                    break;
                case 3:
                    browseSlotRegistrations();
                    break;
                case 4:
                    browseGyms();
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

    private void browseGyms() {
        List<Gym> gyms = gymService.viewAllGyms();

	    Utils.printFormattedTableHeader("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s | %-8s |",
	            "Gym ID", "Gym Name", "Location", "Description", "Total Slots", "Price per Slot", "Approved");

	    for (Gym gym : gyms) {
            Utils.printFormattedTableRow("| %-10s | %-20s | %-15s | %-30s | %-10s | $%-15s | %-8s |",
	                gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymDescription(),
	                gym.getTotalSlots(), gym.getPricePerSlot(), gym.isApproved() ? "Approved" : "Processing");
	    }


    }
    
    private void browseOwnerRegistrations() {
            // Get the list of gym owners awaiting approval
            List<GymOwner> owners = ownerService.getOwners();

            if (owners.isEmpty()) {
                System.out.println("No pending owner registrations.");
                return;
            }

            // Print the table header
            Utils.printFormattedTableHeader("| %-5s | %-20s | %-5s | %-15s | %-15s | %-15s | %-10s | %-8s |",
                    "ID", "Name", "Age", "PAN Card", "Aadhar Card", "GSTIN", "Location", "Approved");

            // Print gym owner details in tabular format
            for (GymOwner owner : owners) {
                Utils.printFormattedTableRow("| %-5s | %-20s | %-5s | %-15s | %-15s | %-15s | %-10s | %-8s |",
                        owner.getOwnerId(), owner.getName(), owner.getAge(), owner.getPanCard(),
                        owner.getAadharCard(), owner.getGstin(), owner.getLocation(), owner.isApproved() ? "Approved" : "Processsing");
            }


            // Ask the admin to approve owners based on ID or press 0 to exit
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.print("Enter the Gym Owner ID to approve (press 0 to exit): ");
                choice = scanner.nextInt();

                if (choice != 0) {
                    // Find the Gym Owner with the given ID
                    GymOwner selectedOwner = ownerService.getGymOwnerById(choice);

                    if (selectedOwner != null) {
                        // Approve the Gym Owner
                        selectedOwner.setApproved(true);
                        ownerService.updateProfile(selectedOwner);
                        System.out.println("Gym Owner with ID " + choice + " approved successfully!");
                    } else {
                        System.out.println("Gym Owner not found with the provided ID.");
                    }
                }

            } while (choice != 0);

            System.out.println("Exiting owner approval process.");
        }
 


    private void browseGymRegistrations() {
        // Get the list of gyms awaiting approval
        List<Gym> pendingGyms = gymService.viewAllGyms();

        if (pendingGyms.isEmpty()) {
            System.out.println("No pending gym registrations.");
            return;
        }

        Utils.printFormattedTableHeader("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s | %-8s |",
	            "Gym ID", "Gym Name", "Location", "Description", "Total Slots", "Price per Slot", "Approved");

	    // Print gym details
	    for (Gym gym : pendingGyms) {

            String textColor = gym.isApproved() ? "\033[0;32m" : "\033[0;31m";
            Utils.printFormattedTableRow("| %-10s | %-20s | %-15s | %-30s | %-10s | $%-15s | %-8s |",
	                gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymDescription(),
	                gym.getTotalSlots(), gym.getPricePerSlot(), gym.isApproved() ? "Approved" : "Processing");
	    }

        // Ask the admin to approve gyms based on ID or press 0 to exit
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Enter the Gym ID to approve (press 0 to exit): ");
            choice = scanner.nextInt();

            if (choice != 0) {
                // Find the Gym with the given ID
                Gym selectedGym = gymService.getGym(choice);

                if (selectedGym != null) {
                    // Approve the Gym
                    selectedGym.setApproved(true);
                    gymService.updateGym(selectedGym);
                    System.out.println("Gym with ID " + choice + " approved successfully!");
                } else {
                    System.out.println("Gym not found with the provided ID.");
                }
            }

        } while (choice != 0);

        System.out.println("Exiting gym approval process.");
    }

    private void browseSlotRegistrations() {
        // Get the list of slots awaiting approval
        List<Slot> pendingSlots = slotService.getAllSlot();

        if (pendingSlots.isEmpty()) {
            System.out.println("No pending slot registrations.");
            return;
        }

        // Print the table header
        Utils.printFormattedTableHeader("| %-5s | %-5s | %-20s | %-15s | %-5s |",
                "ID", "Gym ID", "Start Time", "Total Seats", "Approved");

        // Print slot details in tabular format
        for (Slot slot : pendingSlots) {
            Utils.printFormattedTableRow("| %-5s | %-5s | %-20s | %-15s | %-5s |",
                    slot.getSlotId(), slot.getGymId(), slot.getStartTime(), slot.getTotalSeats(), slot.isApproved() ? "Approved" : "Processing");
        }


        // Ask the admin to approve slots based on ID or press 0 to exit
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Enter the Slot ID to approve (press 0 to exit): ");
            choice = scanner.nextInt();

            if (choice != 0) {
                // Find the Slot with the given ID
                Slot selectedSlot = slotService.getSlot(choice);

                if (selectedSlot != null) {
                    // Approve the Slot
                    selectedSlot.setApproved(true);
                    slotService.updateSlot(selectedSlot);
                    System.out.println("Slot with ID " + choice + " approved successfully!");
                } else {
                    System.out.println("Slot not found with the provided ID.");
                }
            }

        } while (choice != 0);

        System.out.println("Exiting slot approval process.");
    }

    private void verifyPayments() {
        // Implement logic to verify payments
    }
}
