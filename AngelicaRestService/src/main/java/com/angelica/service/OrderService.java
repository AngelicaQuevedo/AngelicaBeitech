package com.angelica.service;

import java.util.Date;
import java.util.List;

import com.angelica.model.Order;
import com.angelica.webservice.restapi.wrapper.ProductDetail;

public interface OrderService {

    public Date generateProductsOrder(Long customerId, String deliveryAddress, List<ProductDetail> productsToOrder);
    
    public List<Order> getOrdersByCustomer(Long customerId);
    
}
