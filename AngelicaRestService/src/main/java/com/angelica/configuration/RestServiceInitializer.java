package com.angelica.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RestServiceConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/API/*" };
    }
}
