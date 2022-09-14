package com.pushkarev.online_shop.configuration;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.pushkarev.online_shop")
@EnableWebMvc
public class Config {
			
	@Bean
	public DataSource dataSource() {
		PGSimpleDataSource ds = new PGSimpleDataSource();
		ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
		ds.setUser("postgres");
		ds.setPassword("1234");
		ds.setDatabaseName("postgres");
	    ds.setCurrentSchema("online_shop");
		return ds;
	}
}
