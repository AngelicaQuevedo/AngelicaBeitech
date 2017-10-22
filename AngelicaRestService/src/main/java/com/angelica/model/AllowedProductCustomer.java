package com.angelica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALLOWED_PRODUCT_CUSTOMER")
public class AllowedProductCustomer {
	
    @Id
    @Column(name = "product_customer_id")
	private Integer productCustomerId;
    
}
