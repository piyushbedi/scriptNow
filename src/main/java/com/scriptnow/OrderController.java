package com.scriptnow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Collections.singletonList;

@RestController
public class OrderController {

    @RequestMapping("/order")
    public Order getPrescription(@RequestParam(value="name", defaultValue="World") String userName) {
        Medicine med = new Medicine("Panadol");
        Prescription prescription = new Prescription(singletonList(med));
        return new Order(prescription, new User(userName));
    }
}
