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
		
		UserVo userVo = userDao.selectUserById(username);
		if(userVo == null) {
			throw new UsernameNotFoundException(username);
		}else {
		
			List<UserRoleVo> roles = userDao.selectRoleByUserSeq(userVo.getUserSeq());
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
	public void insertUser(UserVo userVo) {
		
		//회원 등록
		userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
		userDao.insertUser(userVo);
		int userSeq = userVo.getUserSeq();
		LOG.debug("userSeq = " + userSeq);
		
		//권한 등록
		UserRoleVo userRole = new UserRoleVo();
		userRole.setUserSeq(userSeq);
		userRole.setRole(userVo.getRole());
		userDao.insertRole(userRole);
	}
	
	/**
	 * 회원리스트 가져오기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	public List<UserVo> selectUserByCondition(UserVo userVo){
		return userDao.selectUserByCondition(userVo);
	}
	
	/**
	 * 회원 수정하기
	 *  
	 * @author jongyoon.park
	 * @return 
	 * @since 2019. 5. 13.
	 */
	@Transactional
	public void updateUser(UserVo userVo) {
		userDao.updateUser(userVo);
	}
	
	/**
	 * 회원 삭제하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@Transactional
	public void deleteUser(int userSeq) {
		userDao.deleteUser(userSeq);
	}
	
	/**
	 * userSeq를 가지고 회원정보를 가져온다
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public UserVo selectUserByUserSeq(int userSeq) {
		return userDao.selectUserByUserSeq(userSeq);
	}
}
