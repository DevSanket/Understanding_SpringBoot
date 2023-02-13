package com.sanketscode.TodoApp.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationConfiguration {
	
	
	//filter chain
	//authenticated all requests
	//basic authetication
	// disable csrf
	//stateless rest api
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 return 
	                http
	                    .authorizeHttpRequests(
	                        auth -> 
	                        auth
	                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() //NEW
	                        .anyRequest().authenticated()	                        )
	                    .httpBasic(Customizer.withDefaults())
	                    .sessionManagement(
	                        session -> session.sessionCreationPolicy
	                        (SessionCreationPolicy.STATELESS))
	                    .csrf().disable()
	                    .build();
	}
	
}
