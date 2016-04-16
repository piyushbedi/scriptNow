package com.scriptnow;

/**
 * Created by piyushbedi on 16/04/2016.
 */
public class Order {

    private Prescription prescription;
    private User username;

    public Order(Prescription prescription, User username) {
        this.prescription = prescription;
        this.username = username;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
