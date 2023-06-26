package com.restraunt.restrauntApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class CustomPasswordEncoder {

	private PasswordEncoder passwordEncoder;
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
	
	
	public CustomPasswordEncoder() {
		this.passwordEncoder=new BCryptPasswordEncoder();
	}

}
