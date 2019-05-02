package com.tsp.caw.user.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDTO implements UserDetails {
	
	private int userSeq;
	private String userId;
	private String userPwd;
	private String userName;
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public String getPassword() {
		return userPwd;
	}
	
	@Override
	public String getUsername() {
		return userPwd;
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
