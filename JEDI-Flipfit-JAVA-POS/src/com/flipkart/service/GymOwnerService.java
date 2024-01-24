package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;

public interface GymOwnerService {
	void addGym(Gym gmy);
	
	List<Gym> getAllGyms(int userId);
}
