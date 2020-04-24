package com.haiming.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackages = {"com.haiming.controller", "com.haiming.services", "com.haiming.beans",
            "com.haiming.aspect"})
@MapperScan(basePackages = {"com.haiming.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
@Import(SpringSecurityConfig.class)
public class AppConfig{
}
