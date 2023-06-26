package com.restraunt.restrauntApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.restraunt.restrauntApp.config.CustomPasswordEncoder;
import com.restraunt.restrauntApp.domain.User;
import com.restraunt.restrauntApp.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOpt = userRepo.findByUsername(username);
		
		return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
		
	}

	

}
