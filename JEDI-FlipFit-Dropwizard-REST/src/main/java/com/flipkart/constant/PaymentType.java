/**
 * This enum represents the different types of payment methods available.
 */
package com.flipkart.constant;

/**
 * Enum representing the different types of payment methods available.
 */
public enum PaymentType {

    /**
     * Cash payment method.
     */
    CASH("Cash"),

    /**
     * Card payment method.
     */
    CARD("Card"),

    /**
     * UPI payment method.
     */
    UPI("Upi");


    private PaymentType(String paymentType){
        this.paymentType = paymentType;
    }

    private final String paymentType;

}
