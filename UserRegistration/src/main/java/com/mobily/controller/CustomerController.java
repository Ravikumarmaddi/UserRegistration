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

import com.mobily.model.Customer;
import com.mobily.model.Status;
import com.mobily.services.CustomerServices;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServices customerServices;

	static final Logger logger = Logger.getLogger(CustomerController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addCustomer(@RequestBody Customer customer) {
		try {
			customerServices.addEntity(customer);
			return new Status(1, "Customer added Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status updateCustomer(@RequestBody Customer customer) {
		try {
			customerServices.addEntity(customer);
			return new Status(1, "Customer updated Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Customer getCustomer(@PathVariable("id") long id) {
		Customer customer = null;
		try {
			customer = customerServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Customer> getCustomer() {

		List<Customer> customerList = null;
		try {
			customerList = customerServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteCustomer(@PathVariable("id") long id) {

		try {
			customerServices.deleteEntity(id);
			return new Status(1, "Customer deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
