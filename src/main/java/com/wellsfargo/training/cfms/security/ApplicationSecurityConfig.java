package com.wellsfargo.training.cfms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@SuppressWarnings("deprecation")
@Configuration
//@EnableWebSecurity


public class ApplicationSecurityConfig   {
	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().antMatchers("/register","/findUsers","/loginUser",
	        					"/postTransactions","/getTransactions","/getTransactionById");
	    }
	}
