package com.scriptnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    public OrderController() {
//        this.orderRepository = new OrderRepository();
//        this.pharmacyRepository = new PharmacyRepository();
//        seedUsers();
//        seedPrescriptions();
    }

    @RequestMapping("/order")
    public Order getPrescription(@RequestParam(value="name", defaultValue="World") String userName) {
        return new Order(1L, "Panadol");
    }

    @RequestMapping("/orders")
    public List<Order> getActiveOrders() {
        return orderRepository.getActiveOrders();
    }

    @RequestMapping(method = POST, path = "/newOrder")
    public Order createOrder(@RequestParam("medicine") String medicine) {
        return orderRepository.createOrder(medicine);
    }

    @RequestMapping(method = POST, path = "/canFillOrder/{orderId}")
    public void canFillOrder(@RequestParam("orderId") Long orderId) {
        orderRepository.canFulFillOrder(orderId);
    }

    private void seedPrescriptions() {
        Medicine panadol = new Medicine("Panadol");
        Medicine lipitor = new Medicine("Lipitor");
        Medicine neurofen = new Medicine("Neurofen");
        Medicine coughLollies = new Medicine("coughLollies");

        Prescription p1 = new Prescription(Arrays.asList(panadol, lipitor));
        Prescription p2 = new Prescription(Arrays.asList(neurofen));
        Prescription p3 = new Prescription(Arrays.asList(coughLollies));
        this.orderRepository.createOrder(p1);
        this.orderRepository.createOrder(p1);
        this.orderRepository.createOrder(p2);
    }

    private void seedUsers() {
        this.pharmacyRepository.addUser("Ken");
        this.pharmacyRepository.addUser("Sindu");
    }
}
