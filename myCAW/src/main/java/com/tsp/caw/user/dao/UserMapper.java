package com.tsp.caw.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tsp.caw.user.dto.UserDTO;
import com.tsp.caw.user.dto.UserRoleDTO;

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
public interface UserMapper {
	
	/**
	 * 회원리스트 가져오기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	public List<UserDTO> readUser();
	
	/**
	 * userId를 가지고 회원정보를 가져온다
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public UserDTO readUserById(String id);
	
	/**
	 * 회원 등록
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public int createUser(UserDTO userDTO);
	
	/**
	 * userSeq를 가지고 회원권한정보를 가져온다
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 7.
	 */
	public List<UserRoleDTO> readRole(int userSeq);
	
	/**
	 * 권한 등록
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 8.
	 */
	public void createRole(UserRoleDTO userRoleDTO);
}
