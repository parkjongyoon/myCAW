package com.tsp.caw.user.service;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tsp.caw.user.dao.UserMapper;
import com.tsp.caw.user.dto.UserDTO;

@Service
public class UserService implements UserDetailsService {
	private static final Log LOG = LogFactory.getLog( UserService.class );

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOG.debug("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		
		UserDTO userDTO = userMapper.readUser(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException(username);
		}
		
		ArrayList<GrantedAuthority> authorities = new ArrayList();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		userDTO.setAuthorities(authorities);
		return userDTO;
	}
	
	public void createUser(UserDTO userDTO) {
		userDTO.setUser_pwd(passwordEncoder.encode(userDTO.getUser_pwd()));
		userMapper.createUser(userDTO);
	}

}
