package com.mobily.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.dao.CustomerDao;
import com.mobily.model.Customer;

public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public boolean addEntity(Customer customer) throws Exception {
		return customerDao.addEntity(customer);
	}

	@Override
	public Customer getEntityById(long id) throws Exception {
		return customerDao.getEntityById(id);
	}

	@Override
	public List<Customer> getEntityList() throws Exception {
		return customerDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return customerDao.deleteEntity(id);
	}

	@Override
	public boolean updateEntity(Customer customer) throws Exception {
		return customerDao.updateEntity(customer);
	}

}
