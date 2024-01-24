package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Slot;

public interface GymService {
	List<Slot> getSlots(int userId);
}
