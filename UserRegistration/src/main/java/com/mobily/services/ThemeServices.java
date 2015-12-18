package com.mobily.services;

import java.util.List;

import com.mobily.model.Theme;

public interface ThemeServices {
	public boolean addEntity(Theme theme) throws Exception;
	public Theme getEntityById(long id) throws Exception;
	public List<Theme> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
