/**
 * This class is an implementation of the NotificationFlipFitService interface.
 * It provides methods to send notifications and retrieve all notifications for a user.
 */
package com.flipkart.service.serviceImpl;

import java.util.List;

import com.flipkart.bean.Notification;
import com.flipkart.service.NotificationFlipFitService;

/**
 * This class implements the NotificationFlipFitService interface and provides
 * the functionality to send notifications and retrieve all notifications for a user.
 */
public class NotificationFlipFitServiceImpl implements NotificationFlipFitService {

	/**
	 * Sends a notification to a user with the specified user ID and message.
	 *
	 * @param userId  the ID of the user
	 * @param message the message to be sent
	 */
	@Override
	public void sendNotification(int userId, String message) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retrieves all notifications for a user with the specified user ID.
	 *
	 * @param userId the ID of the user
	 * @return a list of notifications for the user
	 */
	@Override
	public List<Notification> getAllNotifications(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
