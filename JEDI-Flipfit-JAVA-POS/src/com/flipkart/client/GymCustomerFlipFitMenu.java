/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BinaryOperator;

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
	GymCustomerFlipFitService customerService = new GymCustomerFlipFitServiceImpl();
	GymFlipFitService gymService = new GymFlipFitServiceImpl();
	SlotFlipFitService slotService = new SlotFlipFitServiceImpl();
	BookingFlipFitServiceImpl bookingService = new BookingFlipFitServiceImpl();
	int index = 1; 
	
    public void displayCustomerMenu(User user) {
        int option;
        do {
            System.out.println("\n\n\033[1m--------- Gym Customer Menu Options ------\033[0m" + 
				"\nPress 1. Browse Gyms" +
				"\nPress 2. View Gym Details " + 
				"\nPress 3. Book a Slot " + 
				"\nPress 4. Cancel Booking " +
				"\nPress 5. View Booking History " + 
				"\nPress 6. Modify Booking" + 
				"\nPress 7. View Profile" +
				"\nPress 8. Update Profile" + 
//				"\nPress 9. Browse Waitlist" + 
//				"\nPress 10. Cancel Waitlist" + 
//				"\nPress 11. Payment" +
				"\nPress 12. Exit");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch(option) {
                case 1:
                    browseGyms();
                    break;
                case 2:
                    viewGymDetails(sc);
                    break;
                case 3:
                    bookSlot(sc, user);
                    break;
                case 4:
                    cancelBooking(sc, user);
                    break;
                case 5:
                    viewBookingHistory(user);
                    break;
                case 6:
                	modifyBooking();
                    break;
                case 7:
                    viewProfile(user);
                    break;
                case 8:
                    updateProfile(user);
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
                case 12:
                    System.out.println("\033[1mYou have exited the Gym Customer menu\033[0m");
                    break;
                default:
                    System.out.println("\033[1mYou have selected an invalid option. Please try again!!\033[0m");
                    break;
            }

        }
        while (option != 12);
    }

    private void updateProfile(User user) {
    	customerService.updateProfile(user);
		
	}

	private void viewProfile(User user) {
		customerService.viewProfile(user);
	}

	private void browseGyms() {
        // Implement logic to browse available gyms
        System.out.println("\nGyms in Bangalore \n1. Bellandur \n2. Whitefield \n3. Indranagar\n");
		System.out.println("\033[1mGymID\tGymName\t\tLocation\033[0m");
		System.out.println("-----------------------------------------------------------");
		
		gymService.viewAllGyms().forEach(gym -> System.out.println(gym.getGymId() + "\t" + gym.getGymName() + "\t\t"
					+ gym.getLocation()));
		
    }

    private void viewGymDetails(Scanner sc) {
    	System.out.println("\nEnter GymID for which you want to view the details: ");
    	int gymId = sc.nextInt();
    	gymService.displayGymDetails(gymId);
    }

    private void bookSlot(Scanner sc, User user) {
    	ArrayList<Slot> slots = slotService.getAllAvailableSlots();
		System.out.println("\n\033[1m---------------------- Available Slots -----------------------\033[2m\n");
		System.out.println("Slot No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------");
		index = 1;					
		for(Slot slot: slots) {
			System.out.println(index+"\t\t"+slot.getSlotHour()+":00-"+(slot.getSlotHour()+1)+":00"+"\t\t"+slot.getGymId());
			index++;
		}
		System.out.println("Enter the slot number you want to book: ");
		int slotIndex = sc.nextInt();
		if(slotIndex < index) {
			customerService.bookSlot(slots.get(slotIndex-1).getGymId(), slots.get(slotIndex-1).getSlotHour(), user.getUserId());
		}
		else {
			System.out.println("Unknown Slot!");
		}
    }

    private void cancelBooking(Scanner sc, User user) {
        // Implement logic to cancel a booked slot
    	ArrayList<Slot> bookedSlots = bookingService.viewBookings(user.getUserId());
		System.out.println("\n\033[1m---------------------- Your Bookings -----------------------\033[2m\n");
		System.out.println("\033[1mBooking No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------\\033[0m");
		index = 1;
		for(Slot slot: bookedSlots) {
			System.out.println(index+"\t\t"+slot.getSlotHour()+":00-"+(slot.getSlotHour()+1)+":00"+"\t\t"+slot.getGymId());
			index++;
		}
		System.out.println("\nPlease enter the booking number to be cancelled");
		int bookingIndex = sc.nextInt();
		if(bookingIndex < index)
			customerService.cancelSlot(bookedSlots.get(bookingIndex-1).getGymId(), bookedSlots.get(bookingIndex-1).getSlotHour(), user.getUserId());
		else
			System.out.println("\033[1mNo such booking number exists!\033[0m");
    }

    private void viewBookingHistory(User user) {
    	ArrayList<Slot>  bookedSlots = bookingService.viewBookings(user.getUserId());
    	System.out.println("\n\033[1m---------------------- Your Bookings -----------------------\033[2m\n");
		System.out.println("\033[1mBooking No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------\033[0m");
		index = 1;
		for(Slot slot: bookedSlots) {
			System.out.println(index+"\t\t"+slot.getSlotHour()+":00-"+(slot.getSlotHour()+1)+":00"+"\t\t"+slot.getGymId());
			index++;
		}
    }

    private void modifyBooking() {
        // Implement logic to modify a booked slot
    }
    
//    private void browseWaitlist() {
//        // Implement logic to browse the waitlist
//    }
//    private void viewPlanBasedOnDay() {
//        // Implement logic to view the plan based on the day
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
