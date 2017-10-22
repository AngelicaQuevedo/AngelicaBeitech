package com.angelica.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.angelica.dao.AbstractDao;
import com.angelica.dao.ProductDao;
import com.angelica.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao{

	@Override
	public List<Product> getAllowedProductsByCustomer(Integer customerId) {
		Query query = getSession().createSQLQuery("select product from AllowedProductCustomer where customerId = :customerId");
		query.setInteger("customerId", customerId);
		
		return null;
	}

}
