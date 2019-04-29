package com.lovo.boot.outController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lovo.boot.bean.UserEntity;
import com.lovo.boot.bean.UserRoleDto;
import com.lovo.boot.service.IRolePowerService;
import com.lovo.boot.service.IRoleUserService;
import com.lovo.boot.service.IUserService;
import com.lovo.boot.util.JSONChange;

@RestController
public class OutRoleUserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleUserService  roleUserService;
	
	
	
	@RequestMapping("{roleName}/{roleId}/gotoRoleUser")
	public String gotoRoleUser(@PathVariable("roleName")String roleName,@PathVariable("roleId")String roleId)throws JsonParseException, JsonMappingException, IOException{
	    //根据角色ID查询出拥有的用户
		List<UserEntity> listUser=	userService.getUserListByRoleId(roleId);
		//根据角色ID查询出不拥有的用户
		List<UserEntity> nolistUser=userService.getNOUserListByRoleId(listUser);
		
		UserRoleDto dto=new UserRoleDto();
		dto.setListUser(listUser);
		dto.setNolistUser(nolistUser);
		dto.setRoleId(roleId);
		dto.setRoleName(roleName);
		
			String listJson = JSONChange.objToJson(dto);
		
		
		return listJson;
		
		
	}
	
	
	@RequestMapping("{roleName}/{roleId}/{addName}/{delName}/updateRoleUser")
	public String  updateRoleUser(@PathVariable("roleName")String roleName,@PathVariable("roleId")String roleId
			,@PathVariable("addName")String addName,@PathVariable("delName")String delName) throws JsonProcessingException{
		
		//添加用户
		if(!addName.equals("0")) {
		roleUserService.andUserList(addName, roleId);
		}
		//删除用户
		if(!delName.equals("0")) {
		roleUserService.delUserList(delName, roleId);
		}
		
		
		//根据角色ID查询出拥有的用户
		List<UserEntity> listUser=	userService.getUserListByRoleId(roleId);
		//根据角色ID查询出不拥有的用户
		List<UserEntity> nolistUser=userService.getNOUserListByRoleId(listUser);
		

		UserRoleDto dto=new UserRoleDto();
		dto.setListUser(listUser);
		dto.setNolistUser(nolistUser);
		dto.setRoleId(roleId);
		dto.setRoleName(roleName);
		

		String listJson = JSONChange.objToJson(dto);
	
	
	    return listJson;
	
	}
	
	
			
}
