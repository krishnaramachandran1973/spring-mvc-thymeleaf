package com.wipro.config;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.Filter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { JpaConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		/*
		 * final CharacterEncodingFilter cef = new CharacterEncodingFilter();
		 * cef.setEncoding(StandardCharsets.UTF_8.name()); cef.setForceEncoding(true);
		 */
		return new Filter[] { new HiddenHttpMethodFilter(), new OpenEntityManagerInViewFilter() };
	}
}
