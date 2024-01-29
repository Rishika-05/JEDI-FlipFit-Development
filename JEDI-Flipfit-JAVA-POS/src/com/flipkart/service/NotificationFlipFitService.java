/**
 * The NotificationFlipFitService interface provides methods to send notifications and retrieve all notifications for a user.
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Notification;

public interface NotificationFlipFitService {
	
	/**
	 * Sends a notification to a user.
	 * 
	 * @param userId the ID of the user
	 * @param message the message to be sent
	 */
	void sendNotification(int userId, String message);
	
	/**
	 * Retrieves all notifications for a user.
	 * 
	 * @param userId the ID of the user
	 * @return a list of Notification objects representing the notifications
	 */
	List<Notification> getAllNotifications(int userId);
}
