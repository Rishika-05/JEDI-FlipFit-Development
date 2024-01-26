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
    GymOwner getGymOwnerById(int userId);
    GymOwner updateProfile(GymOwner owner);
	List<GymOwner> getAllOwners();
    public GymOwner viewProfile(int id);
    public boolean register(GymOwner owner);
    void approveGymOwnerById(int id);

}
