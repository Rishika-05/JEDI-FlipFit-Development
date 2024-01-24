/**
 * 
 */
package com.flipkart.bean;

import java.time.LocalDateTime;

/**
 * 
 */
public class Booking {
<<<<<<< HEAD
    private int id;
    private int user_id;
    private int gym_id;
    int slot_id;




=======
    private int bookingId;
    private int userId;
    private int gymId;
    private int slotId;
    private LocalDateTime bookingDate = LocalDateTime.now();
    private boolean isCancelled;
>>>>>>> f82c245 (feat: added all bean properties)
}
