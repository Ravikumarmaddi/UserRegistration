package com.mobily.controller.test;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ImportResource(value="file:src/main/webapp/WEB-INF/spring-config.xml")
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring-config.xml")
public class BaseIntegrationTestConfig {
	
	@Autowired
	WebApplicationContext wac;
	
	@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        //factory.addErrorPages(new ErrorPage(HttpStatus.404, "/notfound.html"));
        return factory;
    }
	
	@Bean
    public DispatcherServlet dispatcherServlet()
    {
        return new DispatcherServlet();
    }
	
	/*@PostConstruct
	public void setup() {
		System.out.println("ServletContext.."+wac.getServletContext());
	}*/
	
	/*@Bean
	public ServletContextInitializer initializer() {
	    return new ServletContextInitializer() {

	        @Override
	        public void onStartup(ServletContext servletContext) throws ServletException {
	            //servletContext.setInitParameter("p-name", "-value");
	        	System.out.println("On Startup ServletContextInitializer");
	        	servletContext.setInitParameter("contextConfigLocation", "/WEB-INF/spring-config.xml");
	        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	        	
	        	servletContext.addListener(new ContextLoaderListener(wac));
	            ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(wac));
	            dispatcher.setLoadOnStartup(1);
	            dispatcher.addMapping("/");
	        }
	    };
	}*/
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new TestRestTemplate();
	}
	
	/*@Autowired
	public void context(ApplicationContext context) {
		System.out.println("***************** APPLICATION CONTEXT AUTOWIRED ********************"+context);
		AnnotationConfigEmbeddedWebApplicationContext wac = (AnnotationConfigEmbeddedWebApplicationContext)context;
		ServletContext servletContext = wac.getServletContext();
		System.out.println("***************** SERVLET CONTEXT ********************"+servletContext);
        servletContext.addListener(new ContextLoaderListener(wac));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(wac));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}*/
	
}
