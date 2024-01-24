/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public enum NotificationType {
    EMAIL("Email"),
    SMS("SMS");

    private NotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    private final String notificationType;
}
