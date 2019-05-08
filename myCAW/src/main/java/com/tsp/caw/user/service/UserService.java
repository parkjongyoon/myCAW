package com.tsp.caw.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsp.caw.user.dao.UserMapper;
import com.tsp.caw.user.dto.UserDTO;
import com.tsp.caw.user.dto.UserRoleDTO;

 /**
 * 회원 service
 * 
 * @author jongyoon.park
 * @since 2019. 5. 8.
 * 
 *        <pre>
 *     since                 author                     description
 *  ===========    =============    ===========================
 * 2019. 5. 8.             jongyoon.park       	             최초 생성
 *        </pre>
 */
@Service
public class UserService implements UserDetailsService {
	private static final Log LOG = LogFactory.getLog( UserService.class );

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 회원정보 및 권한정보 UserDetails에 세팅하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO userDTO = userMapper.readUserById(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException(username);
		}else {
		
			List<UserRoleDTO> roles = userMapper.readRole(userDTO.getUserSeq());
			ArrayList<GrantedAuthority> authorities = new ArrayList();
			
			for(UserRoleDTO role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRole()));
			}
			
			userDTO.setAuthorities(authorities);
		}
		return userDTO;
	}
	
	/**
	 * 회원 가입하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	@Transactional
	public void createUser(UserDTO userDTO) {
		
		//회원 등록
		userDTO.setUserPwd(passwordEncoder.encode(userDTO.getUserPwd()));
		userMapper.createUser(userDTO);
		int userSeq = userDTO.getUserSeq();
		LOG.debug("userSeq = " + userSeq);
		
		//권한 등록
		UserRoleDTO userRole = new UserRoleDTO();
		userRole.setUserSeq(userSeq);
		userRole.setRole(userDTO.getRole());
		userMapper.createRole(userRole);
	}

}
