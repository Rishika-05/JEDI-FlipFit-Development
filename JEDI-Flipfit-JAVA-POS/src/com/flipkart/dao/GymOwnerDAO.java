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
    boolean removeGym(int gymId);
    boolean modifyGym(int gymId);
    void addSlot(Gym gym);
    void modifySlot(int gymId);
    List<String> viewSlots(int gymId);
    void removeSlot(int gymId);

    GymOwner viewProfile(User user);
    GymOwner updateProfile(GymOwner owner);
}
