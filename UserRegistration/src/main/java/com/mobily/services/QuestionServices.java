package com.mobily.services;

import java.util.List;

import com.mobily.model.Question;

public interface QuestionServices {
	public boolean addEntity(Question question) throws Exception;
	public Question getEntityById(long id) throws Exception;
	public List<Question> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
