package com.mobily.services;

import java.util.List;

import com.mobily.model.Customer;

public interface CustomerServices {
	public boolean addEntity(Customer customer) throws Exception;
	public boolean updateEntity(Customer customer) throws Exception;
	public Customer getEntityById(long id) throws Exception;
	public List<Customer> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
