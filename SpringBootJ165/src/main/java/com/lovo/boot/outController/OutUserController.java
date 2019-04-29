package com.lovo.boot.outController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lovo.boot.bean.UserEntity;
import com.lovo.boot.dao.RoleDao;
import com.lovo.boot.dao.RolePowerDao;
import com.lovo.boot.dao.RoleUserDao;
import com.lovo.boot.service.IPowerService;
import com.lovo.boot.service.IRolePowerService;
import com.lovo.boot.service.IRoleService;
import com.lovo.boot.service.IRoleUserService;
import com.lovo.boot.service.IUserService;
import com.lovo.boot.service.impl.RoleServiceImpl;
import com.lovo.boot.util.JSONChange;
@RestController
public class OutUserController {

	@Autowired
	private IUserService userService;
	
	   @Autowired
		private IRoleService roleService;
	   
	   @Autowired
		private IPowerService powerService;
	    
	    @Autowired
		private IRolePowerService rolePowerService;
	    
	    @Autowired
		private IRoleUserService  roleUserService;
	    
	   
	    
	
	@RequestMapping("{userStr}/{sysTag}/zhuce")
	public UserEntity zhuce(@PathVariable("userStr") String userStr,@PathVariable("sysTag")String sysTag) throws JsonParseException, JsonMappingException, IOException {
		UserEntity user = new UserEntity();
		user = (UserEntity) JSONChange.jsonToObj(user, userStr);
		UserEntity u = userService.savaUser(user);
		return u;
	}
	

	@RequestMapping("{roleId}/delRole")
	public void delRoleByRole(@PathVariable("roleId") String roleId) {
		
		rolePowerService.delRoleUserByRoleId(roleId);
		roleUserService.delRoleUserByRoleId(roleId);
		roleService.delete(roleId);
	}
	
	
	@RequestMapping("{pid}/delPower")
	public void delPower(@PathVariable("pid") String pid) {
		rolePowerService.delRolePowerByPowerId(pid);
		powerService.delPower(pid);
		
	}
	
}
