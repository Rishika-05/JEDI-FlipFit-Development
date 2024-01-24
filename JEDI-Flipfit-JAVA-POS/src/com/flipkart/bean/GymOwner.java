/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class GymOwner extends User {
    private String aadhar;
    private String bankAccount;

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
