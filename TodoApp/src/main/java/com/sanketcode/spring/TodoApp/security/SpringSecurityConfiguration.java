package com.sanketcode.spring.TodoApp.security;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	


	//LDAP or Database
	//IN memory
	
//	InMemoryUserDetailsManager
//	inMemoryUserDetailsManager(UserDetails... userDetails)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
	 UserDetails userDetails = createNewUser("admin", "123456");
	 UserDetails userDetails2 = createNewUser("Ranga", "dummy");	
		return new InMemoryUserDetailsManager(userDetails,userDetails2);
	}


	private UserDetails createNewUser(String username, String password) {
		Function<String, String> PasswordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails =	User.builder()
			.passwordEncoder(PasswordEncoder)
			.username(username)
			.password(password)
			.roles("USER","ADMIN")
			.build();
		return userDetails;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//All Urls are Protected
	// A Login from is show for unauthorized requests
	//CSRF disable 
	//Frames
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
	

}
