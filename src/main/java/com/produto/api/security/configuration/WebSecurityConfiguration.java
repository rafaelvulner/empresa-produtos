package com.produto.api.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.produto.api.security.service.AuthProviderService;


@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthProviderService authProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/usuario/create")		 
		 .authenticated()
		.and()       
        .httpBasic();
		
	  }

	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	  }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		// ignore all URLs that start with /resources/ or /static/
		           .antMatchers("/usuario/create");
	}

}
