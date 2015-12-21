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

import com.mobily.model.Status;
import com.mobily.model.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@ActiveProfiles("test")
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes=BaseIntegrationTestConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ThemeControllerTest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test1CreateThemeService() {
		
		Map<String, Object> requestBody = new HashMap<String, Object>();
		
		requestBody.put("name", "Theme 1");
		requestBody.put("description", "First Theme");
		/*requestBody.put("categoryId", "302");*/
		/*requestBody.put("file_path", "/src/file.txt");*/
		
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
				restTemplate.postForObject("http://localhost:8080/theme/create", httpEntity, Map.class);
		  
		Assert.assertNotNull(apiResponse);
		
		String message = apiResponse.get("message").toString();
		
		Assert.assertEquals("Theme added Successfully !", message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test2GetAllThemesService() {
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
		List<Theme> Themes =
				restTemplate.getForObject("http://localhost:8080/theme/list", List.class);
		  
		Assert.assertNotNull(Themes);
		
		Assert.assertNotEquals(0, Themes.size());
		
	}
	
	@Test
	public void test3GetThemeService() {
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
		Theme theme =
				restTemplate.getForObject("http://localhost:8080/theme/401", Theme.class);
		  
		Assert.assertNotNull(theme);
		
		Assert.assertEquals(theme.getThemeId(), 401);
	}
	
	@Test
	public void test4DeleteThemeService() {
		
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
        msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
		
		
		//Invoking the API
        Status status =
				restTemplate.getForObject("http://localhost:8080/theme/delete/401", Status.class);
		  
		Assert.assertNotNull(status);
		
		Assert.assertEquals("Theme deleted Successfully !", status.getMessage());

	}

}
