package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface GymOwnerFlipFitService {
	
	void addGym(Gym gym);
	List<Gym> getAllGyms(int userId);
	
	void addTimeSlot(Gym gym);
	
	GymOwner viewProfile(User user);
	GymOwner updateProfile(GymOwner owner);
	
}
