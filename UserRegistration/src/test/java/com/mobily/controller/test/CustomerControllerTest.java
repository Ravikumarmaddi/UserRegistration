package com.mobily.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.mobily.model.Customer;
import com.mobily.model.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@ActiveProfiles("test")
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes=BaseIntegrationTestConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test1CreateCustomerService() {
		
		Map<String, Object> requestBody = new HashMap<String, Object>();
		
		requestBody.put("userName", "User 1");
		requestBody.put("password", "pass1234");
		requestBody.put("encryptKey", "key one");
		requestBody.put("firstName", "First One");
		requestBody.put("lastName", "Last One");
		requestBody.put("email", "user.one@gmail.com");
		requestBody.put("selfDescription", "First Customer");
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> accept = new ArrayList<MediaType>();
		accept.add(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(accept);
		
		//Creating http entity object with request body and headers
		HttpEntity<Map<String, Object>> httpEntity =
		       new HttpEntity<Map<String, Object>>(requestBody, requestHeaders);
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
		Map<String, Object> apiResponse =
				restTemplate.postForObject("http://localhost:8080/customer/create", httpEntity, Map.class);
		  
		Assert.assertNotNull(apiResponse);
		
		String message = apiResponse.get("message").toString();
		
		Assert.assertEquals("Customer added Successfully !", message);

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test2GetAllCustomersService() {
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
		List<Customer> customers =
				restTemplate.getForObject("http://localhost:8080/customer/list", List.class);
		  
		Assert.assertNotNull(customers);
		
		Assert.assertNotEquals(0, customers.size());
		
	}
	
	@Test
	public void test3GetCustomerService() {
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
		Customer customer =
				restTemplate.getForObject("http://localhost:8080/customer/101", Customer.class);
		  
		Assert.assertNotNull(customer);
		
		Assert.assertEquals(customer.getCustomerId(), 101);

	}
	
	@Test
	public void test4DeleteCustomerService() {
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
        Status status =
				restTemplate.getForObject("http://localhost:8080/customer/delete/101", Status.class);
		  
		Assert.assertNotNull(status);
		
		Assert.assertEquals("Customer deleted Successfully !", status.getMessage());

	}
	
}
