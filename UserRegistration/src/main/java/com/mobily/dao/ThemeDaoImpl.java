package com.mobily.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.model.Theme;

public class ThemeDaoImpl implements ThemeDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Theme theme) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(theme);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Theme getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Theme theme = (Theme) session.load(Theme.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return theme;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theme> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Theme> employeeList = session.createCriteria(Theme.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Theme.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
