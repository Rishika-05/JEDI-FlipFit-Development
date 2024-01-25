/**
 * 
 */
package com.flipkart.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.daoImpl.GymOwnerDAOImpl;
import com.flipkart.service.GymOwnerFlipFitService;

import java.time.LocalDateTime;

/**
 * 
 */
public class GymOwnerFlipFitServiceImpl implements GymOwnerFlipFitService {
	List<Gym> gyms = new ArrayList<Gym>();
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
				Scanner sc = new Scanner(System.in);

				System.out.println("Start Time: ");
				LocalDateTime startTime = sc.nextLine();



				g.setSlots(slot);
			}
		}
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
