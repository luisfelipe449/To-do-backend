package com.luis.todo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.luis.todo.services.DBService;

@Configuration
@Profile("test")
public class TestConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
	}

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instancia() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}
}
