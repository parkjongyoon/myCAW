package com.tsp.caw.user.dto;

import lombok.Data;

/**
 * UserRole DTO
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
public class UserRoleDTO {

	private int userSeq;
	private String role;
}
