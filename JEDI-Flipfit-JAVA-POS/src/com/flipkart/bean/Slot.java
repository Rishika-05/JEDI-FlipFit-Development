/**
 * 
 */
package com.flipkart.bean;

import java.time.LocalDateTime;

/**
 * 
 */
public class Slot {
    private int slotId;
    private int gymId;
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime = LocalDateTime.now();
    private LocalDateTime slotTime = LocalDateTime.now();
    private int avilableSeats;
    private int filledSeats;
}
