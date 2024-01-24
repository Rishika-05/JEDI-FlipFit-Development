package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Notification;

public interface NotificationFlipFitService {
	void sendNotification(int userId, String message);
	
	List<Notification> getAllNotifications(int userId);
}
