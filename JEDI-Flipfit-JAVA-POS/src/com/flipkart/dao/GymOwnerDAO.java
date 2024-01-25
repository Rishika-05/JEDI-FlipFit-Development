/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

/**
 * 
 */
public interface GymOwnerDAO {
    void addGym(Gym gym);
    List<Gym> getAllGyms(int userId);

    void addTimeSlot(Gym gym);

    GymOwner getGymOwnerById(int userId);
    GymOwner updateProfile(GymOwner owner);
	List<GymOwner> getAllOwners();
}
