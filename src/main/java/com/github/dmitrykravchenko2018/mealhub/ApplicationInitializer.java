package com.github.dmitrykravchenko2018.mealhub;

import com.github.dmitrykravchenko2018.mealhub.config.SpringConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        final Class<?>[] servletConfigClasses = {
                SpringConfiguration.class
        };
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        final String[] servletMappings = {"/"};
        return servletMappings;
    }

}
