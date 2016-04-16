package com.scriptnow;

/**
 * Created by piyushbedi on 16/04/2016.
 */
public class Order {

    Long id;
    private String prescription;

    public Order(Long id, String prescription) {
        this.id = id;
        this.prescription = prescription;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
