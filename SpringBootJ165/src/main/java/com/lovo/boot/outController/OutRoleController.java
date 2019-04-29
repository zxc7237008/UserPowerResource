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
import com.lovo.boot.bean.RoleEntity;
import com.lovo.boot.service.IRoleService;
import com.lovo.boot.util.JSONChange;




@RestController
public class OutRoleController {
	@Autowired
	private IRoleService roleService;
	
	
	//添加角色
	@RequestMapping("{roleStr}/{sysTag}/savaRole")
	public RoleEntity savaRole(@PathVariable("roleStr") String roleStr,@PathVariable("sysTag")String sysTag) throws JsonParseException, JsonMappingException, IOException {
		RoleEntity role = new RoleEntity();
		role = (RoleEntity) JSONChange.jsonToObj(role, roleStr);
		RoleEntity u = roleService.savaRole(role);
		return u;
	}
	
	//查询所有角色
		@RequestMapping("findAllRole")
		public String findAllRole() throws JsonProcessingException{
			List<RoleEntity> list= roleService.findAllListRole();
			String listJson = JSONChange.objToJson(list);
			
			
		
			   return listJson;
		}
		
		@RequestMapping("delectRole")
		public void delectRole(@PathVariable("roleStr") String roleStr) throws JsonParseException, JsonMappingException, IOException {
			
			
			
		}
		
		
		
		
}
