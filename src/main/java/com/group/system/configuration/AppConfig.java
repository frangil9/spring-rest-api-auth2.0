package com.group.system.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

 
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.group.system")
public class AppConfig extends WebMvcConfigurerAdapter{
	
}