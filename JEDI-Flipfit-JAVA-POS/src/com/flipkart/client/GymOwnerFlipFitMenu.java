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
/**
 *
 */
public class GymOwnerFlipFitMenu {
	GymOwnerFlipFitService ownerService = GymOwnerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
    public void displayGymOwnerMenu(int userId) {
        int menuOption;
        int gymOwnerId = ownerService.getGymOwnerId(userId);
        if(!ownerService.getGymOwnerById(gymOwnerId).isApproved()) {
        	System.out.println("Please wait for your approval. Try again some time later.");
        	Scanner in = new Scanner(System.in);
        	System.out.println("\n\nPress any key to exit: ");
        	in.next();
        	return;
        }
        do {
            System.out.println("\n\n ----------- Gym Owner Menu Options ---------- " + 
        "\nPress 1. Add a new gym Centre" +
        "\nPress 2. View Gyms" +
        "\nPress 3. Remove Gym" +
        "\nPress 4. Modify Gym" +
        "\nPress 5. Register Slots " + 
        "\nPress 6. Modify Slots " + 
        "\nPress 7. View Slots " +  
        "\nPress 8. Remove Slots " +  
        "\nPress 9. View Profile" +
        "\nPress 10. Update Profile" +
        "\nPress 11. Quit \n");
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
                case 11:
                	System.out.println("\033[1mYou have exited the Gym Owner menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }
        } while (menuOption != 11);

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
	                System.out.println("Gym removed successfully!");
	            } else {
	                System.out.println("Failed to remove the gym. Please try again.");
	            }
	        } else {
	            System.out.println("Gym not found with the provided ID.");
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
                    selectedGym.setLocation(newLocation);
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

                default:
                    System.out.println("Invalid choice. No modifications performed.");
                    return;
            }
            
            gymService.updateGym(selectedGym);
            System.out.println("Gym modified successfully!");
        } else {
            System.out.println("Gym not found with the provided ID.");
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
    	        for (Slot slot : slots) {
    	            System.out.printf("Slot ID: %-5d | Start Time: %-15s | Slot Time: %-10d | Total Seats: %-5d\n",
    	                    slot.getSlotId(), slot.getStartTime(), slot.getSlotTime(), slot.getTotalSeats());
    	        }

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
    	                    System.out.println("Invalid choice. No modifications performed.");
    	                    return;
    	            }

    	            // Update the slot in the service
    	            slotService.updateSlot(selectedSlot);
    	            boolean updated =  true;
    	            if (updated) {
    	                System.out.println("Slot modified successfully!");
    	            } else {
    	                System.out.println("Failed to update the slot. Please try again.");
    	            }
    	        } else {
    	            System.out.println("Slot not found with the provided ID.");
    	        }
    	    } else {
    	        System.out.println("Gym not found with the provided ID.");
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
            for (Slot slot : slots) {
                System.out.printf("Slot ID: %-5d | Start Time: %-15s | Slot Time: %-10d | Total Seats: %-5d\n",
                        slot.getSlotId(), slot.getStartTime(), slot.getSlotTime(), slot.getTotalSeats());
            }

            // Ask the user for the slot ID to remove
            System.out.print("Enter the Slot ID to remove: ");
            int slotId = scanner.nextInt();

            if (slotId != 0) {
                // Remove the slot from the list
                slotService.removeSlot(slotId);
                System.out.println("Slot removed successfully!");
            } else {
                System.out.println("Slot not found with the provided ID.");
            }
        } else {
            System.out.println("Gym not found with the provided ID.");
        }
    }


	private void addNewGym(Scanner in, int gymOwnerId) {
    	Gym newGym = new Gym();
    	
    	newGym.setGymOwnerId(gymOwnerId);
    	System.out.print("\033[0;34mEnter gym name: \033[0m");
    	String gymName = in.next();
    	in.nextLine();
    	newGym.setGymName(gymName);

    	System.out.print("\033[0;34mEnter gym location: \033[0m");
    	String location = in.next();
    	in.nextLine();
    	newGym.setLocation(location);

    	System.out.print("\033[0;34mEnter gym description: \033[0m");
    	String gymDescription = in.next();
    	in.nextLine();
    	newGym.setGymDescription(gymDescription);

    	System.out.print("\033[0;34mEnter total slots: \033[0m");
    	int totalSlots = in.nextInt();
    	newGym.setTotalSlots(totalSlots);
    	
    	System.out.print("\033[0;34mEnter price per slot: \033[0m");
    	int price = in.nextInt();
    	newGym.setPricePerSlot(price);
    	
    	gymService.addGym(newGym);

    }

	private void viewRegisteredGyms(int userId) {
	    List<Gym> gyms = ownerService.getAllGyms(userId);

	    // Print table header
	    System.out.println("---------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s | %-8s |\n",
	            "Gym ID", "Gym Name", "Location", "Description", "Total Slots", "Price per Slot", "Approved");
	    System.out.println("---------------------------------------------------------------------");

	    // Print gym details
	    for (Gym gym : gyms) {
	        System.out.printf("| %-10d | %-20s | %-15s | %-30s | %-10d | $%-15d | %-8s |\n",
	                gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymDescription(),
	                gym.getTotalSlots(), gym.getPricePerSlot(), gym.isApproved() ? "Yes" : "No");
	    }

	    System.out.println("---------------------------------------------------------------------");
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
            System.out.println("Time slots registered successfully!");
        } else {
            System.out.println("Gym not found with the provided ID.");
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
	            System.out.println("-------------------------------------------------------------");
	            System.out.printf("| %-10s | %-10s | %-10s | %-15s |\n",
	                    "Slot ID", "Start Time", "Slot Time", "Total Seats");
	            System.out.println("-------------------------------------------------------------");

	            // Print slot details
	            for (Slot slot : slots) {
	                System.out.printf("| %-10d | %-10s | %-10d | %-15d |\n",
	                        slot.getSlotId(), slot.getStartTime(), slot.getSlotTime(), slot.getTotalSeats());
	            }

	            System.out.println("-------------------------------------------------------------");
	        } else {
	            System.out.println("Gym not found with the provided ID.");
	        }
	  }
	
	  private void viewProfile(int userId) {
		  GymOwner gymOwner = ownerService.getGymOwnerById(userId);

		    if (gymOwner != null) {
		        // Print table header
		        System.out.println("-------------------------------------------------------");
		        System.out.printf("| %-15s | %-5s | %-15s | %-15s | %-15s | %-15s |\n",
		                "Name", "Age", "Pan Card", "Aadhar Card", "GSTIN", "Location");
		        System.out.println("-------------------------------------------------------");

		        // Print gym owner details
		        System.out.printf("| %-15s | %-5d | %-15s | %-15s | %-15s | %-15s |\n",
		                 gymOwner.getName(), gymOwner.getAge(),
		                gymOwner.getPanCard(), gymOwner.getAadharCard(), gymOwner.getGstin(), gymOwner.getLocation());

		        System.out.println("-------------------------------------------------------");

		    } else {
		        System.out.println("Gym owner not found.");
		    }
	  }
	  private void updateProfile(int userId) {
		  GymOwner gymOwner = ownerService.getGymOwnerById(userId);
		  Scanner sc = new Scanner(System.in);

          System.out.println("What do you want to update?");
          System.out.println("1. Name");
          System.out.println("2. Age");
          System.out.println("3. Pan Card");
          System.out.println("4. Aadhar Card");
          System.out.println("5. GSTIN");
          System.out.println("6. Location");

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
                  System.out.print("Enter new Pan Card No.: ");
                  String newPanCard = sc.nextLine();
                  gymOwner.setPanCard(newPanCard);
                  break;

              case 4:
                  System.out.print("Enter new Aadhar Card No.: ");
                  String newAadharCard = sc.nextLine();
                  gymOwner.setAadharCard(newAadharCard);
                  break;

              case 5:
                  System.out.print("Enter new GSTIN No.: ");
                  String newGstin = sc.nextLine();
                  gymOwner.setGstin(newGstin);
                  break;

              case 6:
                  System.out.print("Enter new location: ");
                  String newLocation = sc.nextLine();
                  gymOwner.setLocation(newLocation);
                  break;

              default:
                  System.out.println("Invalid choice. No updates performed.");
                  return;
          }

          System.out.println("Profile updated successfully!");
	  }

}
