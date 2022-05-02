package com.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
//	@Override
//	public void onStartup(ServletContext context) throws ServletException {
//		
//		super.onStartup(context);
//		ServletRegistration.Dynamic servlet = context.addServlet("h2-console", new WebServlet());
//		servlet.setLoadOnStartup(2);
//		servlet.addMapping("/console/*");
//		
//	}

}
