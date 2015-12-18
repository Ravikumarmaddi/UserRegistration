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

import com.mobily.model.Question;
import com.mobily.model.Status;
import com.mobily.services.QuestionServices;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionServices questionServices;

	static final Logger logger = Logger.getLogger(QuestionController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addQuestion(@RequestBody Question question) {
		try {
			questionServices.addEntity(question);
			return new Status(1, "Question added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Question getQuestion(@PathVariable("id") long id) {
		Question question = null;
		try {
			question = questionServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return question;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Question> getQuestion() {

		List<Question> questionList = null;
		try {
			questionList = questionServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return questionList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteQuestion(@PathVariable("id") long id) {

		try {
			questionServices.deleteEntity(id);
			return new Status(1, "Question deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
