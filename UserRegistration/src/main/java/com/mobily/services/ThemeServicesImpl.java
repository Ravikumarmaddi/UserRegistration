package com.mobily.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobily.dao.ThemeDao;
import com.mobily.model.Theme;

public class ThemeServicesImpl implements ThemeServices {

	@Autowired
	ThemeDao themeDao;
	
	@Override
	public boolean addEntity(Theme theme) throws Exception {
		return themeDao.addEntity(theme);
	}

	@Override
	public Theme getEntityById(long id) throws Exception {
		return themeDao.getEntityById(id);
	}

	@Override
	public List<Theme> getEntityList() throws Exception {
		return themeDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return themeDao.deleteEntity(id);
	}

}
