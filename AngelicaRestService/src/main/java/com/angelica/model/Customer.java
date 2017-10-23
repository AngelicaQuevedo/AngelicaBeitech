package com.angelica.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="CUSTOMER")
public class Customer{

    @Id
    @Column(name = "CUSTOMER_ID")
	private BigInteger customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JoinTable(name = "ALLOWED_PRODUCT_CUSTOMER", 
//    		joinColumns = { @JoinColumn(name = "customer_id") }, 
//    		inverseJoinColumns = { @JoinColumn(name = "product_id") })
//    private List<Product> products = new ArrayList<>();
    @ManyToMany
    private List<Product> allowedProducts = new ArrayList<>();

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
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

	public List<Product> getProducts() {
		return allowedProducts;
	}

	public void setProducts(List<Product> products) {
		this.allowedProducts = products;
	}

	

}
