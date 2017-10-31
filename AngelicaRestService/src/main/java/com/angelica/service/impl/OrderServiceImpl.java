package com.angelica.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelica.dao.OrderDao;
import com.angelica.model.Order;
import com.angelica.model.OrderDetail;
import com.angelica.service.OrderService;
import com.angelica.webservice.restapi.wrapper.ProductDetail;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Date generateProductsOrder(Long customerId, String deliveryAddress, List<ProductDetail> productsToOrder) {

        Order order = new Order();
        Float orderTotal = 0F;
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetailItem;

        for (ProductDetail productDetail : productsToOrder) {
        	orderTotal = orderTotal + productDetail.getProductPrice();
            orderDetailItem = new OrderDetail();
            orderDetailItem.setOrder(order);
            orderDetailItem.setProductId(productDetail.getProductId());
            orderDetailItem.setPrice(productDetail.getProductPrice());
            orderDetailItem.setDetailDescription(productDetail.getDescription());
            orderDetails.add(orderDetailItem);
        }
        
        Date currentDate = new Date();
        
        order.setCreationDate(currentDate);
        order.setCustomerId(customerId);
        order.setDeliveryAddress(deliveryAddress);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 5);
        Date deliveryDate = calendar.getTime();
        
        order.setDeliveryDate(deliveryDate);
        order.setTotal(orderTotal);
        order.setOrderDetails(orderDetails);
        
        orderDao.addNewOrder(order);
        return deliveryDate;
    }
    
    public List<Order> getOrdersByCustomer(Long customerId){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String today = sdf.format(new Date());
    	
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -30);
        String daysBefore = sdf.format(calendar.getTime());
        
    	List<Order> orders = orderDao.getOrdersByCustomer(customerId, today, daysBefore);
    	for (Order order : orders) {
			System.out.println(order);
		}
    	return orders;
    }

}
