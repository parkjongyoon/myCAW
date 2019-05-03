package com.tsp.caw.user.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDTO implements UserDetails {
	
	private int user_seq;
	private String user_id;
	private String user_pwd;
	private String user_name;
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public String getPassword() {
		return user_pwd;
	}
	
	@Override
	public String getUsername() {
		return user_pwd;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
