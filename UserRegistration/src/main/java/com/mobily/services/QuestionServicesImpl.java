package com.mobily.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.dao.QuestionDao;
import com.mobily.model.Question;

public class QuestionServicesImpl implements QuestionServices {

	@Autowired
	QuestionDao questionDao;
	
	@Override
	public boolean addEntity(Question question) throws Exception {
		return questionDao.addEntity(question);
	}

	@Override
	public Question getEntityById(long id) throws Exception {
		return questionDao.getEntityById(id);
	}

	@Override
	public List<Question> getEntityList() throws Exception {
		return questionDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return questionDao.deleteEntity(id);
	}

}
