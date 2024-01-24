package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;

public interface GymOwnerFlipFitService {
	void addGym(Gym gmy);
	
	List<Gym> getAllGyms(int userId);
}
