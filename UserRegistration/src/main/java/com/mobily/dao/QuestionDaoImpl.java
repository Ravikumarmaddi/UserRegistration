package com.mobily.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.model.Question;

public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Question question) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(question);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Question getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Question question = (Question) session.load(Question.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return question;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Question> employeeList = session.createCriteria(Question.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Question.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
