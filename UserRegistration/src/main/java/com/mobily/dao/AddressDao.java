package com.mobily.dao;

import java.util.List;

import com.mobily.model.Address;

public interface AddressDao {

	public boolean addEntity(Address customer) throws Exception;
	public Address getEntityById(long id) throws Exception;
	public List<Address> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean updateEntity(Address customer);
}
