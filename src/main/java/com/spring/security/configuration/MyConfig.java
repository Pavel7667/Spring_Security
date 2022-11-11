package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * "@Configuration" MyConfig class to Config SpringContainer
 * "@ComponentScan" package for scanning for BEANs
 */
@Configuration
@ComponentScan("com.spring.security")
public class MyConfig {

    /**
     * The viewResolver add to JSP pages full path to file
     * Adding "Prefix" "Suffix" to coming name of JSP pages
     *
     * @return internalResourceViewResolver full path to file
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver =
                new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
