package com.mobily.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.dao.DataDao;
import com.mobily.model.Employee;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

	@Override
	public boolean updateEntity(Employee employee) throws Exception {
		return dataDao.updateEntity(employee);
		
	}

}
