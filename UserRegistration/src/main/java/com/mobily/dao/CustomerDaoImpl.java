package com.mobily.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.model.Address;
import com.mobily.model.Customer;
import com.mobily.model.Theme;

public class CustomerDaoImpl implements CustomerDao {
	/*@Autowired
	AddressDao addressDao;
*/
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Customer customer) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();

		return false;
	}
	@Override
	public boolean updateEntity(Customer customer) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.flush();
		session.update(customer);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Customer getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Customer customer = (Customer) session.load(Customer.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Customer> employeeList = session.createCriteria(Customer.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Customer.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}


/*	public boolean updateEntity2(Customer customer) {
        
		session = sessionFactory.openSession();
		List<Address> addresses = customer.getAddresses();
		for (Address address : addresses) {
			//Address oldAddress = (Address) session.get(Address.class, address.getAccountId());
			session.merge(address);
			session.save(address);
		}
		Theme theme = customer.getTheme();
		session.merge(theme);
		session.saveOrUpdate(theme);
		tx = session.beginTransaction();
		session.merge(customer);
		session.saveOrUpdate(customer);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public boolean updateEntity(Customer customer) {
        
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Address> addresses = customer.getAddresses();
		for (Address address : addresses) {
			Address oldAddress = (Address) session.get(Address.class, address.getAccountId());
			oldAddress.setAddressType(address.getAddressType());
			oldAddress.setAreaName(address.getAreaName());
			oldAddress.setCity(address.getCity());
			oldAddress.setDistrict(address.getDistrict());
			oldAddress.setLandmark(address.getLandmark());
			oldAddress.setPhone1(address.getPhone1());
			oldAddress.setPhone2(address.getPhone2());
			oldAddress.setPostalCode(address.getPostalCode());
			oldAddress.setStreet(address.getStreet());
			oldAddress.setAddressType(address.getAddressType());
			session.merge(oldAddress);
			session.save(oldAddress);
		}
		Theme theme = customer.getTheme();
		Theme oldTheme = (Theme) session.get(Theme.class, theme.getThemeId());
		oldTheme.setCategoryId(theme.getCategoryId());
		oldTheme.setName(theme.getName());
		oldTheme.setDescription(theme.getDescription());
		//session.merge(theme);
		session.saveOrUpdate(theme);
		session.merge(customer);
		Customer oldCustomer = (Customer) session.get(Customer.class, customer.getCustomerId());
		oldCustomer.setActive(customer.getActive());
		oldCustomer.setEmail(customer.getEmail());
		oldCustomer.setEncryptKey(customer.getEncryptKey());
		oldCustomer.setFirstName(customer.getFirstName());
		oldCustomer.setLastName(customer.getLastName());
		oldCustomer.setPassword(customer.getPassword());
		oldCustomer.setSelfDescription(customer.getSelfDescription());
		oldCustomer.setUserName(customer.getUserName());
		session.saveOrUpdate(customer);
		tx.commit();
		session.close();

		return false;
	}
*/
}
