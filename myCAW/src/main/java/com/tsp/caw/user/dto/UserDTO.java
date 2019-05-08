package com.tsp.caw.user.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

 /**
 * 어드민 회원 DTO
 * 
 * @author jongyoon.park
 * @since 2019. 5. 7.
 * 
 *        <pre>
 *     since                 author                     description
 *  ===========    =============    ===========================
 * 2019. 5. 7.             jongyoon.park       	             최초 생성
 *        </pre>
 */
@Data
public class UserDTO implements UserDetails {
	
	private int userSeq;
	private String userId;
	private String userPwd;
	private String userName;
	private String role;
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
