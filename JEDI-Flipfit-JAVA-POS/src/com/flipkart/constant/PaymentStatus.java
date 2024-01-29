/**
 * This enum represents the different payment statuses for a transaction.
 */
package com.flipkart.constant;

/**
 * This enum represents the different payment statuses for a transaction.
 */
public enum PaymentStatus {
    INITIALIZED("Initialized"),
    PROCESSING("Processing"),
    CANCELLED("Cancelled"),
    SUCCESS("Success");


    /**
     * The payment status associated with the enum value.
     */
    private final String paymentStatus;

    /**
     * Constructs a PaymentStatus enum value with the given payment status.
     * @param paymentStatus the payment status associated with the enum value
     */
    private PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
