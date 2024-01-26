/**
 *
 */
package com.flipkart.client;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.service.GymCustomerFlipFitService;
import com.flipkart.service.GymFlipFitService;
import com.flipkart.service.SlotFlipFitService;
import com.flipkart.service.serviceImpl.BookingFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymCustomerFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.GymFlipFitServiceImpl;
import com.flipkart.service.serviceImpl.SlotFlipFitServiceImpl;

/**
 *
 */
public class GymCustomerFlipFitMenu {
	GymCustomerFlipFitService customerService = GymCustomerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
	BookingFlipFitServiceImpl bookingService = new BookingFlipFitServiceImpl();
	int index = 1;

	public void displayCustomerMenu(int userId) {
System.out.println(userId);
		int option;
		int gymCustomerId = customerService.getGymCustomerId(userId);
		do {
			System.out.println("\n\n\033[1m--------- Gym Customer Menu Options ------\033[0m" +
					"\n\033[1;34mPress 1. Browse Gyms" +
					"\nPress 2. Book a Slot " +
					"\nPress 3. Cancel Booking " +
//					"\nPress 4. Modify Booking " +
                    "\nPress 4. View Booking History" +
					"\nPress 5. View Profile" +
					"\nPress 6. Update Profile" +
//                    "\nPress 8. Browse Waitlist" +
//                    "\nPress 9. Cancel Waitlist" +
//                    "\nPress 10. Payment" +
					"\nPress 7. Exit\033[0m\n");
			System.out.print("\033[1mEnter Choice ► \033[0m");
			
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();

			switch (option) {
				case 1:
					browseGyms();
					break;
				case 2:
                    bookSlot(sc, gymCustomerId);
					break;
				case 3:
					cancelBooking(sc, gymCustomerId);
					break;
				case 4:
					viewBookingHistory(gymCustomerId);
					break;
//                case 6:
//                    modifyBooking();
//                    break;
				case 5:
					viewProfile(gymCustomerId);
					break;
				case 6:
					updateProfile(gymCustomerId);
					break;
//                case 9:
//                    browseWaitlist();
//                    break;
//                case 10:
//                    cancelWaitlist();
//                    break;
//                case 11:
//                    payment();
//                    break;
				case 7:
					System.out.println("\033[1mYou have exited the Gym Customer menu\033[0m");
					break;
				default:
					System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
					break;
			}

		} while (option != 7);
	}

	private void updateProfile(int gymCustomerId) {
	    GymCustomer customer = customerService.viewProfile(gymCustomerId);
	    Scanner in = new Scanner(System.in);

	    // Ask the user what to update
	    System.out.println("What do you want to update?");
	    System.out.println("1. Full Name");
	    System.out.println("2. Age");
	    System.out.println("3. Location");

	    int choice = in.nextInt();
	    in.nextLine(); // consume the newline character

	    // Update the chosen property
	    switch (choice) {
	        case 1:
	            System.out.println("Enter your full name: ");
	            String name = in.nextLine();
	            customer.setName(name);
	            break;

	        case 2:
	            System.out.println("Enter your age: ");
	            int age = in.nextInt();
	            in.nextLine(); // consume the newline character
	            customer.setAge(age);
	            break;

	        case 3:
	            System.out.println("Enter your location: ");
	            String location = in.nextLine();
	            customer.setLocation(location);
	            break;

	        default:
	            System.out.println("Invalid choice. No updates performed.");
	            return;
	    }

	    // Attempt to update the profile
	    if (customerService.updateProfile(gymCustomerId, customer)) {
	        System.out.println("\033[1mProfile updated successfully!\033[0m");
	    } else {
	        System.out.println("\033[1mProfile not updated!\033[0m");
	    }
	}


	private void viewProfile(int gymCustomerId) {
	    GymCustomer gymCustomer = customerService.viewProfile(gymCustomerId);

	    // Print table header
	    System.out.println("-------------------------------------------------------------");
	    System.out.printf("| %-15s | %-20s | %-10s | %-5s |\n",
	            "Customer ID", "Name", "Location", "Age");
	    System.out.println("-------------------------------------------------------------");

	    // Print gym customer details
	    System.out.printf("| %-15d | %-20s | %-10s | %-5d |\n",
	            gymCustomerId, gymCustomer.getName(), gymCustomer.getLocation(), gymCustomer.getAge());

	    System.out.println("-------------------------------------------------------------");
	}

	private void browseGyms() {
		// Implement logic to browse available gyms
		 Scanner scanner = new Scanner(System.in);

		    // Ask the user to select a location
		    System.out.println("\n\033[1mSelect a location:\033[0m");
		    System.out.println("1. Bellandur");
		    System.out.println("2. Whitefield");
		    System.out.println("3. Indiranagar");

		    int locationChoice = scanner.nextInt();
		    String selectedLocation;

		    switch (locationChoice) {
		        case 1:
		            selectedLocation = "Bellandur";
		            break;

		        case 2:
		            selectedLocation = "Whitefield";
		            break;

		        case 3:
		            selectedLocation = "Indiranagar";
		            break;

		        default:
		            System.out.println("Invalid choice. Exiting.");
		            return;
		    }

		    // Print the header for the gyms
		    System.out.println("\n\033[1mGyms in " + selectedLocation + "\033[0m");
		    List<Gym> gyms = gymService.getAllGymsByLoc(selectedLocation);
		    displayGyms(gyms);
	}
	
	void displayGyms(List<Gym> gyms) {
		System.out.println("---------------------------------------------------------------------");
	    System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s |\n",
	            "Gym ID", "Gym Name", "Location", "Description", "Total Slots", "Price per Slot");
	    System.out.println("---------------------------------------------------------------------");

	    // Print gym details
	    for (Gym gym : gyms) {
	        System.out.printf("| %-10d | %-20s | %-15s | %-30s | %-10d | $%-14.2f |\n",
	                gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymDescription(),
	                gym.getTotalSlots(), gym.getPricePerSlot());
	    }

	    System.out.println("---------------------------------------------------------------------");
	}


	    private void bookSlot(Scanner sc, int userId) {
	    	GymCustomer gymCustomer = customerService.viewProfile(userId);
	        List<Gym> gyms = gymService.getAllGymsByLoc(gymCustomer.getLocation());
	        displayGyms(gyms);

	        System.out.println("Enter the gym ID you want to book: ");
	        int gymId = sc.nextInt();
	        Gym selectedGym = gymService.getGym(gymId);

	        if (selectedGym != null) {
	            // Get the list of slots for the selected gym
	            List<Slot> slots = slotService.getAllSlotsByGymId(gymId);

	            // Print table header for slots
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

	            System.out.println("Enter the slot ID you want to book: ");
	            int slotId = sc.nextInt();
	            
	            // Check if the selected slot is available
	            if (slotService.isAvailable(slotId)) {
	                // Insert the booking
	                bookingService.insertBooking(userId, gymId, slotId);
	                System.out.println("\n\033[1mBooking successful! Enjoy your workout.\033[0m");
	            } else {
	                System.out.println("\n\033[1mSelected slot is not available. Please choose another slot.\033[0m");
	            }
	        } else {
	            System.out.println("Gym not found with the provided ID.");
	        }
    }

	private void cancelBooking(Scanner sc, int userId) {
		// Implement logic to cancel a booked slot
		List<Booking> bookedSlots = bookingService.getBookingsByUserId(userId);
		displayBooking(bookedSlots);
		System.out.println("\nEnter the booking ID to be cancelled: ");
		int bookingId = sc.nextInt();
		bookingService.cancelBooking(bookingId);
	}
	
	void displayBooking(List<Booking> bookedSlots) {
		 // Print table header for booking history
	    System.out.println("-------------------------------------------------------------");
	    System.out.printf("| %-12s | %-10s | %-10s | %-20s |\n",
	            "Booking ID", "Gym ID", "Slot ID", "Booking Date");
	    System.out.println("-------------------------------------------------------------");

	    // Print booking history details
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    for (Booking booking : bookedSlots) {
	        System.out.printf("| %-12d | %-10d | %-10d | %-20s |\n",
	                booking.getBookingId(), booking.getGymId(), booking.getSlotId(),
	                booking.getBookingDate().format(formatter));
	    }

	    System.out.println("-------------------------------------------------------------");
	}

	private void viewBookingHistory(int userId) {
		List<Booking> bookedSlots = bookingService.getBookingsByUserId(userId);
		System.out.println("\n\033[1m---------------------- Your Bookings -----------------------\033[2m\n");

		displayBooking(bookedSlots);
		
	}

//    private void modifyBooking() {
//        // Implement logic to modify a booked slot
//    }

//    private void browseWaitlist() {
//        // Implement logic to browse the waitlist
//    }
//
//    private void cancelWaitlist() {
//    	System.out.println("Cancel Waitlist");
//    }
//
//    private void payment() {
//    	 System.out.println("Payment Function");
//    }
}
