package com.tsp.caw.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.tsp.caw.user.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	public UserDTO readUser(String userId);
	
	public void createUser(UserDTO userDTO);
}
