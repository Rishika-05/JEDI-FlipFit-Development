/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymCustomer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

/**
 * 
 */
public interface GymOwnerDAO {
    GymOwner getGymOwnerById(int gymOwnerId);
    GymOwner updateProfile(GymOwner owner);
	List<GymOwner> getAllOwners();
    public boolean register(GymOwner owner);
    void approveGymOwnerById(int gymOwnerId);
    int getGymOwnerIdByUserId(int userId);

}
