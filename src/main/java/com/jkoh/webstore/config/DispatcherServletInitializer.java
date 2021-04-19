package com.jkoh.webstore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer 
	extends AbstractAnnotationConfigDispatcherServletInitializer{
	//AACDSInitializer

	//초기화. dispatcher는 하나다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootApplicationContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebApplicationContextConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}
