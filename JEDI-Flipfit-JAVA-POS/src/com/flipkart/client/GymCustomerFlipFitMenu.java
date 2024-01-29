/**
 *
 */
package com.flipkart.client;

import java.time.LocalTime;
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
import com.flipkart.utils.Utils;

/**
 *
 */
public class GymCustomerFlipFitMenu {
	GymCustomerFlipFitService customerService = GymCustomerFlipFitServiceImpl.getInstance();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
	BookingFlipFitServiceImpl bookingService = new BookingFlipFitServiceImpl();

	Utils utils = new Utils();
	int index = 1;

	public void displayCustomerMenu(int userId) {
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
				String formattedLocation = Utils.convertFirstLetterCapital(location);
	            customer.setLocation(formattedLocation);
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

		Utils.printFormattedTableHeader("| %-15s | %-20s | %-10s | %-5s |", "Customer ID", "Name", "Location", "Age");


		Utils.printFormattedTableRow("| %-15s | %-20s | %-10s | %-5s |",
				gymCustomerId,
				gymCustomer.getName(),
				gymCustomer.getLocation(),
				gymCustomer.getAge());

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
		Utils.printFormattedTableHeader("| %-10s | %-20s | %-15s | %-30s | %-10s | %-15s |",
	            "Gym ID", "Gym Name", "Location", "Description", "Total Slots", "Price per Slot");

	    // Print gym details
	    for (Gym gym : gyms) {
			Utils.printFormattedTableRow("| %-10s | %-20s | %-15s | %-30s | %-10s | $%-15s |\n",
	                gym.getGymId(), gym.getGymName(), gym.getLocation(), gym.getGymDescription(),
	                gym.getTotalSlots(), gym.getPricePerSlot());
	    }

	}


	    private void bookSlot(Scanner sc, int userId) {
//	    	GymCustomer gymCustomer = customerService.viewProfile(userId);
	    	 // Ask the user to select a location
		    System.out.println("\n\033[1mSelect a location:\033[0m");
		    System.out.println("1. Bellandur");
		    System.out.println("2. Whitefield");
		    System.out.println("3. Indiranagar");
		    Scanner scanner = new Scanner(System.in);
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
	        System.out.println("Enter the gym ID you want to book: ");
	        int gymId = sc.nextInt();
	        Gym selectedGym = gymService.getGym(gymId);

	        if (selectedGym != null) {
	            // Get the list of slots for the selected gym
	            List<Slot> slots = slotService.getAllSlotsByGymId(gymId);
	         // Print table header for slots
				Utils.printFormattedTableHeader("| %-10s | %-10s | %-10s | %-15s | %-15s |\n",
	                    "Slot ID", "Start Time", "Slot Time", "Total Seats", "Available Seats");

	            // Print slot details
	            for (Slot slot : slots) {
	                int availableSeats = slotService.getAvailableSeats(slot.getSlotId());
					Utils.printFormattedTableRow("| %-10s | %-10s | %-10s | %-15s | %-15s |\n",
	                        slot.getSlotId(), slot.getStartTime(), slot.getSlotTime(), slot.getTotalSeats(), availableSeats);
	            }


	            System.out.println("Enter the slot ID you want to book: ");
	            int slotId = sc.nextInt();
	            
	            // Check if the selected slot is available
	            if (slotService.getAvailableSeats(slotId) > 0) {
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
		if(bookingService.cancelBooking(bookingId))
			 System.out.println("\n\033[1mBooking with ID " + bookingId + " is cancelled successfully\033[0m");
		else
			System.out.println("\n\033[1Error occured!!\033[0m");
	}
	
	void displayBooking(List<Booking> bookedSlots) {
		// Print table header
		Utils.printFormattedTableHeader("| %-12s | %-20s | %-20s | %-20s | %-20s | %-15s |\n",
		        "Booking ID", "Gym Name", "Slot Start Time", "Slot Time", "Booking Date", "Cancelled");

		// Print booking history details
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		for (Booking booking : bookedSlots) {
		    String cancelledStatus = booking.isCancelled() ? "Yes" : "No";
		    // Fetch gym name using gym ID
		    String gymName = gymService.getGym(booking.getGymId()).getGymName();
		    // Fetch slot start time using slot ID
		    LocalTime slotStartTime = slotService.getSlot(booking.getSlotId()).getStartTime();
			Utils.printFormattedTableRow("| %-12s | %-20s | %-20s | %-20s | %-20s | %-15s |\n",
		            booking.getBookingId(), gymName, slotStartTime, booking.getSlotId(),
		            booking.getBookingDate().format(formatter), cancelledStatus);
		}


	}

	private void viewBookingHistory(int userId) {
		List<Booking> bookedSlots = bookingService.getBookingsByUserId(userId);
		System.out.println("\n\033[1m---------------------- Your Bookings -----------------------\033[2m\n");

		displayBooking(bookedSlots);
		
	}


}
