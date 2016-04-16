package com.scriptnow;

/**
 * Created by piyushbedi on 16/04/2016.
 */
public class Medicine {

    private String name;
//    private String strength;
//    private String formulation;
//    private Long quantity;
//    private Long repeats;


    public Medicine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
