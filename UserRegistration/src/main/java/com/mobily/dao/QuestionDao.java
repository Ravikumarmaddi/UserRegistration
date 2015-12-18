package com.mobily.dao;

import java.util.List;

import com.mobily.model.Question;

public interface QuestionDao {

	public boolean addEntity(Question question) throws Exception;
	public Question getEntityById(long id) throws Exception;
	public List<Question> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
