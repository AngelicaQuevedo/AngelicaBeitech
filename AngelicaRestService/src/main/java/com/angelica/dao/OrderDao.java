package com.angelica.dao;

import java.util.List;

import com.angelica.model.Order;

public interface OrderDao {

    public void addNewOrder(Order order);
    
    List<Order> getOrdersByCustomer(Long customerId, String today, String daysBefore);

}
