package com.mobily.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobily.model.Theme;
import com.mobily.model.Status;
import com.mobily.services.ThemeServices;

@Controller
@RequestMapping("/theme")
public class ThemeController {

	@Autowired
	ThemeServices themeServices;

	static final Logger logger = Logger.getLogger(ThemeController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addTheme(@RequestBody Theme theme) {
		try {
			themeServices.addEntity(theme);
			return new Status(1, "Theme added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Theme getTheme(@PathVariable("id") long id) {
		Theme theme = null;
		try {
			theme = themeServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return theme;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Theme> getTheme() {

		List<Theme> themeList = null;
		try {
			themeList = themeServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return themeList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteTheme(@PathVariable("id") long id) {

		try {
			themeServices.deleteEntity(id);
			return new Status(1, "Theme deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
