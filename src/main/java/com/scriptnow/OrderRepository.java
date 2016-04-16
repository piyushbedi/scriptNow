package com.scriptnow;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by piyushbedi on 16/04/2016.
 */
@Repository
public class OrderRepository {

    private Long latestId;
    private Map<Long, Order> activeOrders;
    private Map<Long, Order> fulfilledOrders;
    private Map<Long, Order> closedOrders;

    public OrderRepository() {
        this.latestId = new Long(0);
        this.activeOrders = new HashMap<Long, Order>();
        this.fulfilledOrders = new HashMap<Long, Order>();
        this.closedOrders = new HashMap<Long, Order>();
    }

    public Order createOrder(String prescription) {
        Order newOrder = new Order(latestId, prescription);
        activeOrders.put(newOrder.getId(), newOrder);
        this.latestId++;
        return newOrder;
    }

    public void canFulFillOrder(Long orderId) {
        Order order = activeOrders.get(orderId);
        fulfilledOrders.put(orderId, order);
        activeOrders.remove(orderId);
    }

    public List<Order> getActiveOrders() {
        return new ArrayList<Order>(activeOrders.values());
    }

}
