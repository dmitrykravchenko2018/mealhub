package com.github.dmitrykravchenko2018.mealhub;

import com.github.dmitrykravchenko2018.mealhub.config.JPAConfiguration;
import com.github.dmitrykravchenko2018.mealhub.config.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        final Class<?>[] rootConfigClasses = {
                JPAConfiguration.class
        };
        return rootConfigClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        final Class<?>[] servletConfigClasses = {
                WebConfiguration.class
        };
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        final String[] servletMappings = {"/"};
        return servletMappings;
    }

}
