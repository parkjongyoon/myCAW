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

import com.tsp.caw.user.dao.UserDao;
import com.tsp.caw.user.vo.UserRoleVo;
import com.tsp.caw.user.vo.UserVo;

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
	private UserDao userDao;
	
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
		
		UserVo userVo = userDao.readUserById(username);
		if(userVo == null) {
			throw new UsernameNotFoundException(username);
		}else {
		
			List<UserRoleVo> roles = userDao.readRole(userVo.getUserSeq());
			ArrayList<GrantedAuthority> authorities = new ArrayList();
			
			for(UserRoleVo role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRole()));
			}
			
			userVo.setAuthorities(authorities);
		}
		return userVo;
	}
	
	/**
	 * 회원 가입하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	@Transactional
	public void createUser(UserVo userVo) {
		
		//회원 등록
		userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
		userDao.createUser(userVo);
		int userSeq = userVo.getUserSeq();
		LOG.debug("userSeq = " + userSeq);
		
		//권한 등록
		UserRoleVo userRole = new UserRoleVo();
		userRole.setUserSeq(userSeq);
		userRole.setRole(userVo.getRole());
		userDao.createRole(userRole);
	}
	
	/**
	 * 회원리스트 가져오기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	public List<UserVo> readUser(){
		return userDao.readUser();
	}

}
