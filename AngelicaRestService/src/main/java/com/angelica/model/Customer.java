package com.angelica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer{

    @Id
    @Column(name = "CUSTOMER_ID")
	private Integer customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;
    
    private List<Order> orders;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", orders=" + orders
				+ "]";
	}
	

}
