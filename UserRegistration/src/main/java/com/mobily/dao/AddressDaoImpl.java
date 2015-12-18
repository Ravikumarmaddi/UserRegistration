package com.mobily.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.model.Address;
import com.mobily.model.Address;

public class AddressDaoImpl implements AddressDao {
	@Autowired
	AddressDao addressDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Address address) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(address);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Address getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Address address = (Address) session.load(Address.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return address;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Address> employeeList = session.createCriteria(Address.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Address.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public boolean updateEntity(Address address) {
        
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(address);
		tx.commit();
		session.close();

		return false;
	}

}
