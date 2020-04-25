package com.haiming.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ AppConfig.class };
    }
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext applicationContext =
//                new AnnotationConfigWebApplicationContext();
//        applicationContext.register(SpringSecurityConfig.class);
//        applicationContext.register(AppConfig.class);
//
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
//        ServletRegistration.Dynamic addServlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
//        addServlet.addMapping("/");
//
//    }
}
