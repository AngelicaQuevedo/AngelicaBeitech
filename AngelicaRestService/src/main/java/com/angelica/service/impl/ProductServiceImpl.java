package com.angelica.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelica.model.Product;
import com.angelica.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> getAllowedProductsByCustomer(Integer customerId) {
		return null;
	}

}
