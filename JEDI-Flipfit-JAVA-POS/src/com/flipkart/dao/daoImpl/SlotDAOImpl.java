/**
 * 
 */
package com.flipkart.dao.daoImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;

/**
 * 
 */
public class SlotDAOImpl implements SlotDAO {	
	
	private static SlotDAO slotDAOObj = null;
	
	
	
	public static synchronized SlotDAO getInstance() {
		if (slotDAOObj == null)
			slotDAOObj = new SlotDAOImpl();

		return slotDAOObj;
	}
	
	private ArrayList<Slot> slots = new ArrayList<Slot>();



	@Override
	public void createSlot(Slot slot) {
		slots.add(slot);
	}

	@Override
	public void deleteSlot(int slotId) {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public Slot getSlot(int slotId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Slot> getAllSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Slot> getAllSlots(int gymId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slot updateSlot(Slot slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Slot> getAllAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
