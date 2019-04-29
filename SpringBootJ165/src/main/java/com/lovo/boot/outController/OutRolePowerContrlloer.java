package com.lovo.boot.outController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lovo.boot.bean.PowerEntity;
import com.lovo.boot.bean.RolePowerDto;
import com.lovo.boot.service.IPowerService;
import com.lovo.boot.service.IRolePowerService;
import com.lovo.boot.util.JSONChange;


@RestController
public class OutRolePowerContrlloer {
   @Autowired
   private	IPowerService powerService ;
	
   @Autowired
   private IRolePowerService rolePowerService ;
   
   
   
	
	@RequestMapping("{roleName}/{roleId}/gotoRolePower")
	public String gotoRolePower(@PathVariable("roleName")String roleName,@PathVariable("roleId")String roleId) throws JsonProcessingException{
		//该角色拥有的权限
		 List<PowerEntity> listRolePower=	powerService.findPowerListByRoleId(roleId);
		//该角色不拥有的权限
		 List<PowerEntity> noListRolePower=powerService.noFindPowerListByRoleId(listRolePower, powerService.getPowerList());
		
		RolePowerDto dto = new RolePowerDto();
		dto.setListRolePower(listRolePower);
		dto.setNoListRolePower(noListRolePower);
		dto.setRoleId(roleId);
		dto.setRoleName(roleName);
		String listJson = JSONChange.objToJson(dto);
		return listJson;
	}
	
	
	@RequestMapping("{roleName}/{roleId}/{addName}/{delName}/updateRolePower")
	public String updateRolePower(@PathVariable("roleName")String roleName,@PathVariable("roleId")String roleId,@PathVariable("addName")String addName,
			@PathVariable("delName")String delName	) throws JsonProcessingException{
		
		//添加用户
				if(!addName.equals("0")) {
		//添加角色权限
		rolePowerService.savaRolePower(roleId, addName);
				}
		//删除角色权限
				if(!delName.equals("0")) {	
		rolePowerService.delRolePower(roleId, delName);
				}
		//该角色拥有的权限
		 List<PowerEntity> listRolePower=	powerService.findPowerListByRoleId(roleId);
		//该角色不拥有的权限
		 List<PowerEntity> noListRolePower=powerService.noFindPowerListByRoleId(listRolePower, powerService.getPowerList());
		 RolePowerDto dto = new RolePowerDto();
		 dto.setListRolePower(listRolePower);
		 dto.setNoListRolePower(noListRolePower);
		 dto.setRoleId(roleId);
	     dto.setRoleName(roleName);
	     String listJson = JSONChange.objToJson(dto);
			return listJson;
	}
	
	
	
}
