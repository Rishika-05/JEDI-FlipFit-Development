/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Slot;

import java.util.ArrayList;

/**
 * 
 */
public interface SlotDAO {
    boolean isAvailable();


    boolean addSlot(int slotHour, int gymID, int availableSeats);

    boolean updateSlot(int slotHour, int gymID, int changeInSeats);


    ArrayList<Slot> getAllAvailableSlots();
}
