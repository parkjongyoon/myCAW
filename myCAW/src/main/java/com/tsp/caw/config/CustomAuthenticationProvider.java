package com.tsp.caw.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tsp.caw.user.dto.UserDTO;
import com.tsp.caw.user.service.UserService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Log LOG = LogFactory.getLog( CustomAuthenticationProvider.class );
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserDTO user = (UserDTO) userService.loadUserByUsername(username);
		
		LOG.error("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		LOG.debug("password = " + password);
		LOG.debug("user.getUserPwd() = " + user.getUserPwd());
		LOG.debug("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		if(password.equals(user.getUserPwd())){
			throw new BadCredentialsException(username);
		}
		return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
