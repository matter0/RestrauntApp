package com.restraunt.restrauntApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.MapBasedAttributes2GrantedAuthoritiesMapper;

@Entity
public class Authority implements GrantedAuthority {

	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String authority;
	@ManyToOne
	private User user;
	public Authority() {}
	public Authority(String authority) {
		this.authority=authority;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
 