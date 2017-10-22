package com.angelica.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_DETAIL")
public class OrderDetail {
	
    @Id
    @Column(name = "detail_id")
	private Integer detailId;

    @Column(name = "order_id")
    private Order order;
    
    @Column(name = "customer_id")
    Customer customer;

    @Column(name = "delivery_date")
    private Date deliveryDate;

}
