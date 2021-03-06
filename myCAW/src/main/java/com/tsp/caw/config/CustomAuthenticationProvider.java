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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tsp.caw.user.service.UserService;
import com.tsp.caw.user.vo.UserVo;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Log LOG = LogFactory.getLog( CustomAuthenticationProvider.class );
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		UserVo user = (UserVo) userService.loadUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		if(!passwordEncoder.matches(password, user.getPassword())){
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
