package com.haiming.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.haiming.controller", "com.haiming.services", "com.haiming.beans"})
@MapperScan(basePackages = {"com.haiming.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class AppConfig {
}
