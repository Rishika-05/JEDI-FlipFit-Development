/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.dao.GymDAO;

/**
 * 
 */
public class GymDAOImpl implements GymDAO {
private static GymDAO gymDAOObj = null;
	
	private GymDAOImpl() {
		
	}
	
	public static synchronized GymDAO
	getInstance() {
		if (gymDAOObj == null)
			gymDAOObj = new GymDAOImpl();

		return gymDAOObj;
	}
	
	private ArrayList<Gym> gyms = new ArrayList<Gym>();
	private int gymCount = 1;

	@Override
	public List<Gym> getAllGyms() {
		return gyms;
	}

	@Override
	public Gym getGym(int gymId) {
		for(Gym g: gyms) {
			if(g.getGymId() == gymId) return g;
		}
		System.out.println("Gym not found");
		return null;
	}

	@Override
	public List<Gym> pendingGymRequest() {
		List<Gym> pendingGyms =  new ArrayList<Gym>();
		for(Gym g: gyms) {
			if(!g.isApproved())  pendingGyms.add(g);
		}
		return pendingGyms;
	}

	@Override
	public void addGym(Gym gym) {
		gym.setGymId(gymCount++);
		gyms.add(gym);
	}



	@Override
	public void removeGym(int gymId) {
		for(Gym g: gyms) {
			if(g.getGymId() == gymId) { 
				g.setActive(false);
				System.out.println("Gym removed!!");
				return;
			}
		}
		System.out.println("Gym not found");
	}

	@Override
	public void updateGym(int gymId, Gym gym) {
		for(Gym g: gyms) {
			if(g.getGymId() == gymId) { 
				g.setGymDescription(gym.getGymDescription());
				g.setGymName(gym.getGymName());
				g.setLocation(gym.getLocation());
				g.setTotalSlots(gym.getTotalSlots());
				g.setSlots(gym.getSlots());
				System.out.println("Gym Updated!!");
				return;
			}
		}
		System.out.println("Gym not found.");
	}


}
