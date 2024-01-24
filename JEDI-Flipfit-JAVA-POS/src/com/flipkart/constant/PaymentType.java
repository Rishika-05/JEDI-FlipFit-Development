/**
 * 
 */
package com.flipkart.constant;

/**
 * 
 */
public enum PaymentType {

    CASH("Cash"),
    CARD("Card"),
    UPI("Upi");


    private PaymentType(String paymentType){
        this.paymentType = paymentType;
    }

    private final String paymentType;

}
