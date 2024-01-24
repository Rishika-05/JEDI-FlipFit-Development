/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public enum PaymentStatus {
    INITIALIZED("Initialized"),
    PROCESSING("Processing"),
    CANCELLED("Cancelled"),
    SUCCESS("Success");


    private PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    private final String paymentStatus;
}
