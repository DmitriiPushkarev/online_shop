package com.pushkarev.online_shop.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{	
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception
	{	
		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("ADMIN", "USER", "ANONYMOUS")
		.antMatchers("/showAdminPanel").hasRole("ADMIN")
		.and().formLogin().permitAll()
		.and().logout().permitAll().logoutSuccessUrl("/");;
	}
}
