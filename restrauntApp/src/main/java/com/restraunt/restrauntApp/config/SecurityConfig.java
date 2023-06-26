package com.restraunt.restrauntApp.config;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.BeanIds;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.restraunt.restrauntApp.filter.JwtFilter;
import com.restraunt.restrauntApp.security.JwtAuthenticationEntryPoint;


import com.restraunt.restrauntApp.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailServiceImpl userDetailService;
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	@Autowired
	JwtFilter jwtFilter;
	@Override @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
        	@Override
        	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        		auth.userDetailsService(userDetailService).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
        	}
        	
        	@Override
        	protected void configure(HttpSecurity http) throws Exception {
        		http = http.csrf().disable().cors().disable();
        		
        		http = http.sessionManagement()
        				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        				.and();
        		http=http.exceptionHandling()
        				.authenticationEntryPoint((request,response ,ex) -> {
        					response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage());
        					
        				}).and();
        		http.authorizeRequests()
        			.antMatchers("/api/auth/**").permitAll()
        			.anyRequest().authenticated();
        		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
        	}

    
	

}
