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
    
    @SuppressWarnings("unchecked")
	public List<Order> getOrdersByCustomer(Long customerId, String today, String daysBefore){
    	List<Order> orders = (List<Order>) getSession().createQuery(" from Order where creationDate BETWEEN :startDate AND :endDate and customerId = :customerId")
    			.setString("startDate", daysBefore).setString("endDate", today).setLong("customerId", customerId).list();
    	return orders;
    }

}
