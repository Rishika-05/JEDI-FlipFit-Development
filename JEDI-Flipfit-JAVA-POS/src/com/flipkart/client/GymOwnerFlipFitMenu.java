/**
 *
 */
package com.flipkart.client;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.GymOwnerFlipFitService;
import com.flipkart.service.SlotFlipFitService;
import com.flipkart.service.serviceImpl.GymFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymOwnerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.SlotFlipFitServiceImpl;
import com.flipkart.utils.Utils;

/**
 *
 */
public class GymOwnerFlipFitMenu {
	GymOwnerFlipFitService ownerService = GymOwnerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();

    Utils utils = new Utils();
    public void displayGymOwnerMenu(int userId) {
        int menuOption;
        int gymOwnerId = ownerService.getGymOwnerId(userId);
        if(!ownerService.getGymOwnerById(gymOwnerId).isApproved()) {
            System.out.println("\033[1;31mPlease wait for your approval. Try again some time later.\033[0m");
            Scanner in = new Scanner(System.in);
        	System.out.println("\n\nPress any key to exit: ");
        	in.next();
        	return;
        }
        do {
            Utils.displayLogoUtil("Gym Owner Menu");
            System.out.println("\n\033[1;33mPress 1.\033[0m Add a new gym Centre" +
                    "\n\033[1;33mPress 2.\033[0m View Gyms" +
                    "\n\033[1;33mPress 3.\033[0m Remove Gym" +
                    "\n\033[1;33mPress 4.\033[0m Modify Gym" +
                    "\n\033[1;33mPress 5.\033[0m Register Slots " +
                    "\n\033[1;33mPress 6.\033[0m Modify Slots " +
                    "\n\033[1;33mPress 7.\033[0m View Slots " +
                    "\n\033[1;33mPress 8.\033[0m Remove Slots " +
                    "\n\033[1;33mPress 9.\033[0m View Profile" +
                    "\n\033[1;33mPress 10.\033[0m Update Profile" +
                    "\n\033[1;33mPress 0.\033[0m Quit \n"
            );
            System.out.print("\033[1mEnter Choice ► \033[0m");
            Scanner in = new Scanner(System.in);
            menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                    addNewGym(in, gymOwnerId);
                    break;
                case 2:
                    viewRegisteredGyms(gymOwnerId);
                    break;
                case 3:
                    removeGym(gymOwnerId);
                    break;
                case 4:
                    modifyGym(gymOwnerId);
                    break;
                case 5:
                	registerTimeSlots(gymOwnerId);
                    break;
                case 6:
                    modifySlot(gymOwnerId);
                    break;
                case 7:
                    viewSlots(gymOwnerId);
                    break;
                case 8:
                    removeSlot(gymOwnerId);
                    break;
                case 9:
                    viewProfile(gymOwnerId);
                    break;
                case 10:
                    updateProfile(gymOwnerId);
                    break;
                case 0:
                	System.out.println("\033[1mYou have exited the Gym Owner menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1;31mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 0);

    }

	private void removeGym(int userId) {
		// TODO Auto-generated method stub
		viewRegisteredGyms(userId);
	       Scanner scanner = new Scanner(System.in);

	        // Ask the user for gym ID
	        System.out.print("Enter the Gym ID to remove: ");
	        int gymId = scanner.nextInt();

	        // Find the gym with the given ID
	        Gym selectedGym = gymService.getGym(gymId);

	        if (selectedGym != null) {
	            // Remove the gym from the list
	            boolean removed = gymService.removeGym(gymId);

	            if (removed) {
                    System.out.println("\033[1;32mGym removed successfully!\033[0m");
                } else {
                    System.out.println("\033[1;31mFailed to remove the gym. Please try again.\033[0m");
                }
	        } else {
                System.out.println("\033[1;31mGym not found with the provided ID.\033[0m");
            }
	}

	private void modifyGym(int gymOwnerId) {
		viewRegisteredGyms(gymOwnerId);
		Scanner scanner = new Scanner(System.in);

        // Ask the user for gym ID
        System.out.print("Enter the Gym ID to modify: ");
        int gymId = scanner.nextInt();

        // Find the gym with the given ID
        Gym selectedGym = gymService.getGym(gymId);

        if (selectedGym != null) {
            // Ask the user what to modify
            System.out.println("What do you want to modify?");
            System.out.println("1. Gym Name");
            System.out.println("2. Location");
            System.out.println("3. Gym Description");
            System.out.println("4. Total Slots");
            System.out.println("5. Price per Slots");
    		System.out.print("\033[1mEnter Choice ► \033[0m");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter new Gym Name: ");
                    String newGymName = scanner.nextLine();
                    selectedGym.setGymName(newGymName);
                    break;

                case 2:
                    System.out.print("Enter new Location: ");
                    String newLocation = scanner.nextLine();
                    String formattedNewLoc = utils.convertFirstLetterCapital(newLocation);
                    selectedGym.setLocation(formattedNewLoc);
                    break;

                case 3:
                    System.out.print("Enter new Gym Description: ");
                    String newGymDescription = scanner.nextLine();
                    selectedGym.setGymDescription(newGymDescription);
                    break;

                case 4:
                    System.out.print("Enter new Total Slots: ");
                    int newTotalSlots = scanner.nextInt();
                    selectedGym.setTotalSlots(newTotalSlots);
                    break;
                case 5:
                	System.out.print("\033[0;34mEnter new Price per slot: \033[0m");
                	int price = scanner.nextInt();
                	selectedGym.setPricePerSlot(price);

                default:
                    System.out.println("\033[1;33mInvalid choice. No modifications performed.\033[0m");
                    return;
            }
            
            gymService.updateGym(selectedGym);
            System.out.println("\033[1;32mGym modified successfully!\033[0m");
        } else {
            System.out.println("\033[1;31mGym not found with the provided ID.\033[0m");
        }
	}

    private void modifySlot(int userId) {
    	 viewRegisteredGyms(userId);

    	    Scanner scanner = new Scanner(System.in);

    	    // Ask the user for gym ID
    	    System.out.print("Enter the Gym ID to modify slots: ");
    	    int gymId = scanner.nextInt();

    	    // Find the gym with the given ID
    	    Gym selectedGym = gymService.getGym(gymId);

    	    if (selectedGym != null) {
    	        // Get the list of slots for the selected gym
    	        List<Slot> slots = slotService.getAllSlotsByGymId(gymId);

    	        // Print the slots for the selected gym
    	        System.out.println("Slots for Gym ID " + selectedGym.getGymId() + ":");
                slots.forEach((slot)->{
                    System.out.printf("Slot ID: %-5d | Start Time: %-15s | Slot Time: %-10d | Total Seats: %-5d",
                            slot.getSlotId(), slot.getStartTime(), slot.getSlotTime(), slot.getTotalSeats());
                });

    	        // Ask the user for the slot ID to modify
    	        System.out.print("Enter the Slot ID to modify: ");
    	        int slotId = scanner.nextInt();

    	        // Find the slot with the given ID
    	        Slot selectedSlot = slotService.getSlot(slotId);

    	        if (selectedSlot != null) {
    	            // Ask the user what property to modify
    	            System.out.println("What do you want to modify?");
    	            System.out.println("1. Start Time");
    	            System.out.println("2. Total Seats");

    	            int choice = scanner.nextInt();

    	            // Prompt the user for the new value based on their choice
    	            switch (choice) {
    	                case 1:
    	                    System.out.print("Enter the new start time (HH:mm): ");
    	                    String newStartTimeString = scanner.next();
    	                    LocalTime newStartTime = LocalTime.parse(newStartTimeString, DateTimeFormatter.ofPattern("HH:mm"));
    	                    selectedSlot.setStartTime(newStartTime);
    	                    break;
    	                case 2:
    	                    System.out.print("Enter the new total seats: ");
    	                    int newTotalSeats = scanner.nextInt();
    	                    selectedSlot.setTotalSeats(newTotalSeats);
    	                    break;

    	                default:
                            System.out.println("\033[1;33mInvalid choice. No modifications performed.\033[0m");
                            return;
    	            }

    	            // Update the slot in the service
    	            slotService.updateSlot(selectedSlot);
    	            boolean updated =  true;
    	            if (updated) {
                        System.out.println("\033[1;32mSlot modified successfully!\033[0m");
                    } else {
                        System.out.println("\033[1;31mFailed to update the slot. Please try again.\033[0m");
                    }
    	        } else {
                    System.out.println("\033[1;31mSlot not found with the provided ID.\033[0m");
                }
    	    } else {
                System.out.println("\033[1;31mGym not found with the provided ID.\033[0m");
            }
    }

    private void removeSlot(int userId) {
        viewRegisteredGyms(userId);

        Scanner scanner = new Scanner(System.in);

        // Ask the user for gym ID
        System.out.print("Enter the Gym ID to remove slots: ");
        int gymId = scanner.nextInt();

        // Find the gym with the given ID
        Gym selectedGym = gymService.getGym(gymId);

        if (selectedGym != null) {
            // Get the list of slots for the selected gym
        	List<Slot> slots = slotService.getAllSlotsByGymId(gymId);

            // Print the slots for the selected gym
            System.out.println("Slots for Gym ID " + selectedGym.getGymId() + ":");

            String format = "| %-8s | %-20s | %-10s | %-15s | %-12s |";

            Utils.printFormattedTableHeader(format, "Slot ID", "Start Time", "Slot Time", "Total Seats");
            slots.forEach((slot) -> {
                Utils.printFormattedTableRow(format,
                        String.valueOf(slot.getSlotId()),
                        slot.getStartTime(),
                        String.valueOf(slot.getSlotTime()),
                        String.valueOf(slot.getTotalSeats()));
            });



            // Ask the user for the slot ID to remove
            System.out.print("Enter the Slot ID to remove: ");
            int slotId = scanner.nextInt();

            if (slotId != 0) {
                // Remove the slot from the list
                slotService.removeSlot(slotId);
                System.out.println("\033[1;32mSlot removed successfully!\033[0m");
            } else {
                System.out.println("\033[1;31mSlot not found with the provided ID.\033[0m");
            }
        } else {
            System.out.println("\033[1;31mGym not found with the provided ID.\033[0m");
        }
    }


	private void addNewGym(Scanner in, int gymOwnerId) {
    	Gym newGym = new Gym();
    	
    	newGym.setGymOwnerId(gymOwnerId);
    	System.out.println("\033[0;34mEnter gym name: \033[0m");
    	in.nextLine();
    	String gymName = in.nextLine();
    	newGym.setGymName(gymName);

    	System.out.println("\033[0;34mEnter gym location: \033[0m");
    	String location = in.next();
        String formattedLocation = Utils.convertFirstLetterCapital(location);
    	newGym.setLocation(formattedLocation);

    	System.out.println("\033[0;34mEnter gym description: \033[0m");
    	in.nextLine();
    	String gymDescription = in.nextLine();
    	newGym.setGymDescription(gymDescription);

    	System.out.println("\033[0;34mEnter total slots: \033[0m");
    	int totalSlots = in.nextInt();
    	newGym.setTotalSlots(totalSlots);
    	
    	System.out.println("\033[0;34mEnter price per slot: \033[0m");
    	int price = in.nextInt();
    	newGym.setPricePerSlot(price);
    	
    	gymService.addGym(newGym);

    }

	private void viewRegisteredGyms(int userId) {
	    List<Gym> gyms = ownerService.getAllGyms(userId);

	    // Print table header
	    Utils.printFormattedTableHeader("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s | %-8s | %-6s |",
	            "Gym ID", "Gym Name", "Location", "Description", "Total Slots", "Price per Slot", "Approved", "Deleted");

	    // Print gym details
	    gyms.forEach((gym) -> {
	        Utils.printFormattedTableRow("| %-10s | %-20s | %-15s | %-30s | %-10s | $%-15s | %-8s | %-6s |",
	                gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymDescription(),
	                gym.getTotalSlots(), gym.getPricePerSlot(), gym.isApproved() ? "Approved" : "Processing",
	                gym.isActive() ? "No" : "Yes");
	    });

	}

    private void registerTimeSlots(int userId) {
    	viewRegisteredGyms(userId);
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Gym ID to register time slots: ");
        int gymId = scanner.nextInt();

        // Find the gym with the given ID
        Gym selectedGym = gymService.getGym(gymId);
        if (selectedGym != null) {
            for (int i = 0; i < selectedGym.getTotalSlots(); i++) {
                // Ask the user for time slot details
                System.out.print("Enter the start time for slot " + (i + 1) + " (HH:mm): ");
                String startTimeString = scanner.next();
                LocalTime startTime = LocalTime.parse(startTimeString, DateTimeFormatter.ofPattern("HH:mm"));


                System.out.print("Enter the total seats for slot " + (i + 1) + ": ");
                int totalSeats = scanner.nextInt();
                slotService.addSlot(gymId, startTime, 1, totalSeats);
            }
            System.out.println("\033[1;32mTime slots registered successfully!\033[0m");
        } else {
            System.out.println("\033[1;31mGym not found with the provided ID.\033[0m");
        }
    }


	  private void viewSlots(int userId) {
	        // Implement logic to view the slots
		    viewRegisteredGyms(userId);

	        Scanner scanner = new Scanner(System.in);

	        // Ask the user for gym ID
	        System.out.print("Enter the Gym ID to view slots: ");
	        int gymId = scanner.nextInt();

	        // Find the gym with the given ID
	        Gym selectedGym = gymService.getGym(gymId);

	        if (selectedGym != null) {
	            // Get the list of slots for the selected gym
	        	List<Slot> slots = slotService.getAllSlotsByGymId(gymId);

	        	// Print table header
	            Utils.printFormattedTableHeader("| %-10s | %-10s | %-10s | %-15s | %-10s | %-12s | %-10s | %-10s |",
	                    "Slot ID", "Start Time", "Slot Time", "Total Seats", "Booked Seats", "Deleted", "Approved");

	            // Print slot details
	            slots.forEach((slot) -> {
	                int availableSeats = slotService.getAvailableSeats(slot.getSlotId());
	                int bookedSeats = slot.getTotalSeats() - availableSeats;
	                Utils.printFormattedTableRow("| %-10s | %-10s | %-10s | %-15s | %-12s | %-10s | %-10s |",
	                        slot.getSlotId(), slot.getStartTime(), slot.getSlotTime(), slot.getTotalSeats(),
	                        bookedSeats, slot.isActive() ? "No" : "Yes", slot.isApproved() ? "Approved" : "Processing");
	            });
	            } else {
                System.out.println("\033[1;31mGym not found with the provided ID.\033[0m");
            }
	  }
	
	  private void viewProfile(int userId) {
		    GymOwner gymOwner = ownerService.getGymOwnerById(userId);

		    if (gymOwner != null) {
		        // Print table header
		        Utils.printFormattedTableHeader("| %-15s | %-5s | %-15s | %-15s | %-15s | %-15s | %-15s |",
		                "Name", "Age", "Pan Card", "Aadhar Card", "GSTIN", "Location", "Phone Number", "Email");

		        // Print gym owner details
		        Utils.printFormattedTableRow("| %-15s | %-5s | %-15s | %-15s | %-15s | %-15s | %-15s |",
		                gymOwner.getName(), gymOwner.getAge(),
		                gymOwner.getPanCard(), gymOwner.getAadharCard(), gymOwner.getGstin(), gymOwner.getLocation(),
		                gymOwner.getPhoneNo(), gymOwner.getEmail());

		    } else {
		        System.out.println("\033[1;31mGym owner not found.\033[0m");
		    }
		}

	  private void updateProfile(int userId) {
		  GymOwner gymOwner = ownerService.getGymOwnerById(userId);
		  Scanner sc = new Scanner(System.in);

          System.out.println("What do you want to update?");
          System.out.println("1. Name");
          System.out.println("2. Age");
          System.out.println("3. Location");
//          System.out.println("4. Pan Card");
//          System.out.println("5. Aadhar Card");
//          System.out.println("6. GSTIN");
  		  System.out.print("\033[1mEnter Choice ► \033[0m");
          int choice = sc.nextInt();
          sc.nextLine(); // Consume the newline character

          switch (choice) {
              case 1:
                  System.out.print("Enter new name: ");
                  String newName = sc.nextLine();
                  gymOwner.setName(newName);
                  break;

              case 2:
                  System.out.print("Enter new age: ");
                  int newAge = sc.nextInt();
                  gymOwner.setAge(newAge);
                  break;
                  
              case 3:
                  System.out.print("Enter new location: ");
                  String newLocation = sc.nextLine();
                  gymOwner.setLocation(newLocation);
                  break;

//              case 4:
//                  System.out.print("Enter new Pan Card No.: ");
//                  String newPanCard = sc.nextLine();
//                  gymOwner.setPanCard(newPanCard);
//                  break;
//
//              case 5:
//                  System.out.print("Enter new Aadhar Card No.: ");
//                  String newAadharCard = sc.nextLine();
//                  gymOwner.setAadharCard(newAadharCard);
//                  break;
//
//              case 6:
//                  System.out.print("Enter new GSTIN No.: ");
//                  String newGstin = sc.nextLine();
//                  gymOwner.setGstin(newGstin);
//                  break;

              default:
                  System.out.println("\033[1;31mInvalid choice. No updates performed.\033[0m");
                  return;
          }

          System.out.println("\033[1;32mProfile updated successfully!\033[0m");
      }

}
