package com.tsp.caw.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tsp.caw.user.vo.UserRoleVo;
import com.tsp.caw.user.vo.UserVo;


 /**
 * 어드민 회원 mapper
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
@Mapper
public interface UserDao {
	
	/**
	 * 회원리스트 가져오기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	public List<UserVo> readUser();
	
	/**
	 * userId를 가지고 회원정보를 가져온다
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public UserVo readUserById(String id);
	
	/**
	 * 회원 등록
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public int createUser(UserVo userVo);
	
	/**
	 * userSeq를 가지고 회원권한정보를 가져온다
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public List<UserRoleVo> readRole(int userSeq);
	
	/**
	 * 권한 등록
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	public void createRole(UserRoleVo userRoleVo);
}
