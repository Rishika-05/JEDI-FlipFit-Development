/**
 * 
 */
package com.flipkart.dao.daoImpl;

import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;

import java.util.ArrayList;

/**
 * 
 */
public class SlotDAOImpl implements SlotDAO {
    @Override
    public boolean isAvailable() {
        return false;
    }


    @Override
    public boolean addSlot(int slotHour, int gymID, int availableSeats) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean updateSlot(int slotHour, int gymID, int changeInSeats) {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public ArrayList<Slot> getAllAvailableSlots() {
        // TODO Auto-generated method stub
        return null;
    }
}
