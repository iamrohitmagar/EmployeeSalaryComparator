package com.example.demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class SecureConfig extends WebSecurityConfigurerAdapter {

	@Override()
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.cors().and().csrf().disable().exceptionHandling()
		.and().authorizeRequests()
   		.antMatchers("/localhost:8080").permitAll()
           .antMatchers("/").permitAll();
	}
}
