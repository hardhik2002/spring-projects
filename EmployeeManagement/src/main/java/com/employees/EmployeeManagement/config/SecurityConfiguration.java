package com.employees.EmployeeManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private final String[] ALLOW_LIST = { "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**",
			"/swagger-resources"

	};

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().requestMatchers(ALLOW_LIST).permitAll().anyRequest().permitAll()
				.and().httpBasic();

		return http.build();
	}
}
