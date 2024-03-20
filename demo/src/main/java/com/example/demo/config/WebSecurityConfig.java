package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.CustomAccessDeniedHandler;
import com.example.demo.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired UserDetailsService detailService;
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/empList*").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
			.formLogin().loginPage("/login")
						.usernameParameter("userid")	// 기본값은 username
						.loginProcessingUrl("/userlogin")	// 기본값은 login
						.successHandler(successHandler())
						.permitAll()
			.and()
//			.logout((logout) -> logout.permitAll())
			.logout().logoutSuccessUrl("/customLogout")
			.permitAll()
			.and()
//			.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
			.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler()))
//			.csrf().disable()	// 토큰 미발행처리(미권장)
			.userDetailsService(detailService)
			;
			
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1111")
//				.roles("USER")
//				.build();
//		
//		UserDetails admin =
//				 User.withDefaultPasswordEncoder()
//					.username("admin")
//					.password("1111")
//					.roles("ADMIN")
//					.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}