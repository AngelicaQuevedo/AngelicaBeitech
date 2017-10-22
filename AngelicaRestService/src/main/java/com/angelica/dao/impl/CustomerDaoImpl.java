package com.angelica.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.angelica.dao.AbstractDao;
import com.angelica.dao.CustomerDao;
import com.angelica.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao{

	public Customer findCustomerById(Integer customerId) {
		return getByKey(customerId);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers() {
		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();
	}

}
