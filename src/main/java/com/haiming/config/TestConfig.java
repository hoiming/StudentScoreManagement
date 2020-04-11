package com.haiming.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.haiming.controller", "com.haiming.services", "com.haiming.beans"})
@MapperScan(basePackages = {"com.haiming.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class TestConfig {
}
