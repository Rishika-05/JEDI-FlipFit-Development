/**
 * This class represents a notification in the Flipkart system.
 */
package com.flipkart.bean;

/**
 * This class represents a notification in the Flipkart system.
 */
public class Notification {
    private int notificationId;
    private int userId;
    private String notificationType;
    private String content;

    /**
     * Returns the notification ID.
     * 
     * @return The notification ID.
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the notification ID.
     * 
     * @param notificationId The notification ID to set.
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Returns the user ID associated with the notification.
     * 
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID associated with the notification.
     * 
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the type of the notification.
     * 
     * @return The notification type.
     */
    public String getNotificationType() {
        return notificationType;
    }

    /**
     * Sets the type of the notification.
     * 
     * @param notificationType The notification type to set.
     */
    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    /**
     * Returns the content of the notification.
     * 
     * @return The notification content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the notification.
     * 
     * @param content The notification content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
