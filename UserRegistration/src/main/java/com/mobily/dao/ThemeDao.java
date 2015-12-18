package com.mobily.dao;

import java.util.List;

import com.mobily.model.Theme;

public interface ThemeDao {

	public boolean addEntity(Theme theme) throws Exception;
	public Theme getEntityById(long id) throws Exception;
	public List<Theme> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
