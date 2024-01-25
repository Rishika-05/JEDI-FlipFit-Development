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

    GymOwner viewProfile(User user);
    GymOwner updateProfile(GymOwner owner);
}
