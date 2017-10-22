package com.angelica.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order {
	
    @Id
    @Column(name = "order_id")
	private Integer orderId;

    @Column(name = "delivery_address")
    private String deliveryAddress;
    
    @Column(name = "customer_id")
    Integer customerId;

    @Column(name = "delivery_date")
    private Date deliveryDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getCustomer() {
		return customerId;
	}

	public void setCustomer(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", deliveryAddress=" + deliveryAddress + ", customer=" + customerId
				+ ", deliveryDate=" + deliveryDate + "]";
	}
    

}
