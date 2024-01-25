/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.dao.daoImpl.GymOwnerDAOImpl;
import com.flipkart.service.GymOwnerFlipFitService;

import java.time.LocalDateTime;

/**
 * 
 */
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {
	List<Gym> gyms = new ArrayList<Gym>();
	List<Slot> slots = new ArrayList<Slot>();
	@Override
	public void addGym(Gym gym) {
		// TODO Auto-generated method stub
		gyms.add(gym);
	}

	@Override
	public List<Gym> getAllGyms(int userId) {
		// TODO Auto-generated method stub
		return gyms;
	}
	@Override
	public void addTimeSlot(Gym gym) {
		//logic to add time slot
		for (Gym g : gyms) {
			if (g.getGymId() == gym.getGymId()) {
				Slot slot = new Slot();

				Scanner sc = new Scanner(System.in);

				System.out.println("Slot Id: ");
				int slotId = sc.nextInt();
				slot.setSlotId(slotId);

				System.out.println("Gym Id: ");
				int gymId = sc.nextInt();
				slot.setSlotId(gymId);

				System.out.println("Start Time: ");
				String sTime = sc.nextLine();
				LocalDateTime startTime = parseToLocalDateTime(sTime);
				slot.setStartTime(startTime);

				System.out.println("End Time: ");
				String eTime = sc.nextLine();
				LocalDateTime endTime = parseToLocalDateTime(eTime);
				slot.setStartTime(endTime);

				System.out.println("Available Seats: ");
				int availSeats = sc.nextInt();
				slot.setSlotId(availSeats);

				System.out.println("Duration: ");
				String durationString = sc.next();
				Duration duration = Duration.parse(durationString);
				slot.setSlotTime(duration);

				slots.add(slot);

				g.setSlots(slots);
			}
		}
	}

	private static LocalDateTime parseToLocalDateTime(String input) {
		// Define a DateTimeFormatter for the expected format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// Parse the input string into a LocalDateTime using the formatter
		return LocalDateTime.parse(input, formatter);
	}
	
	@Override
	public GymOwner viewProfile(User user) {
		//Get gym owner profile from username and password
		
		return GymOwnerDAOImpl.getInstance().viewProfile(user);
	}
	
	@Override
	public GymOwner updateProfile(GymOwner gymOwner) {
		//get details and update accordingly
		Scanner sc = new Scanner(System.in);

		System.out.println("Password: ");
		String password = sc.next();
		gymOwner.setPassword(password);

		System.out.println("Pin Code: ");
		String pinCode = sc.next();
		gymOwner.setPincode(pinCode);

		System.out.println("Age: ");
		int age = sc.nextInt();
		gymOwner.setAge(age);

		System.out.println("Pan Card: ");
		String panCard = sc.next();
		gymOwner.setPanCard(panCard);

		System.out.println("Aadhar Card: ");
		String aadhar = sc.next();
		gymOwner.setAadharCard(aadhar);

		System.out.println("GST IN: ");
		String gst = sc.next();
		gymOwner.setGstin(gst);

		System.out.println("Address: ");
		String address = sc.next();
		gymOwner.setAddress(address);

		return GymOwnerDAOImpl.getInstance().updateProfile(gymOwner);
	}
}
