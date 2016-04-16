package com.scriptnow;

import java.util.List;

/**
 * Created by piyushbedi on 16/04/2016.
 */
public class Prescription {

    private List<Medicine> medicines;

    public Prescription(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
