package com.angelica.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.angelica.dao.AbstractDao;
import com.angelica.dao.OrderDao;
import com.angelica.model.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

    @Override
    public void addNewOrder(Order order) {
        persist(order);
    }
    
    public List<Order> getOrdersByCustomer(Long customerId){
    	List<Order> orders = (List<Order>) getSession().createQuery(" from Order where customerId = :customerId").setLong("customerId", customerId).list();
    	return orders;
    }

}
