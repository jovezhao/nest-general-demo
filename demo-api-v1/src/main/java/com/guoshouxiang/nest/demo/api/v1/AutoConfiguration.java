package com.guoshouxiang.nest.demo.api.v1;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class AutoConfiguration {


    @Bean
    public ServletRegistrationBean V1Registration() {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ApiConfiguration.class);

        DispatcherServlet dispatcherServlet
                = new DispatcherServlet(applicationContext);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/api/v1/*");
        registrationBean.setName("api_v1");

        return registrationBean;
    }
}
