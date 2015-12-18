package com.mobily.dao;

import java.util.List;

import com.mobily.model.Customer;

public interface CustomerDao {

	public boolean addEntity(Customer customer) throws Exception;
	public Customer getEntityById(long id) throws Exception;
	public List<Customer> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean updateEntity(Customer customer) throws Exception;
}
