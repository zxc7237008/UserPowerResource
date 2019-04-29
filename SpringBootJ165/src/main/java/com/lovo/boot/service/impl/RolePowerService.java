package com.lovo.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lovo.boot.bean.PowerEntity;
import com.lovo.boot.bean.RoleEntity;
import com.lovo.boot.bean.RolePowerEntity;
import com.lovo.boot.dao.RolePowerDao;
import com.lovo.boot.service.IRolePowerService;

@Service("rolePowerService")
public class RolePowerService implements IRolePowerService {

	@Autowired
	private RolePowerDao rolePowerDao;
	
	public void savaRolePower(String roleId, String addName) {
		//权限ID字符串存在才做操作
       if(null!=addName&&!"".equals(addName)){
    	     //根据逗号截取
    	   String [] powerIdArray=addName.substring(0, addName.length()-1).split(",");
    	   
   List<RolePowerEntity> listRolePower=new ArrayList<>();
    	//循环组装角色权限对象
       for (String powerId : powerIdArray) {
    	   //角色对象
		     RoleEntity role=new RoleEntity();
		     role.setRoleId(roleId);
		     //权限对象
		     PowerEntity power=new PowerEntity();
		     power.setPid(powerId);
		     //角色权限对象
		     RolePowerEntity rolePower=new RolePowerEntity();
		     
		     //把角色对象和权限对象set到角色权限对象
		     rolePower.setPower(power);
		     rolePower.setRole(role);
		     //把角色权限对象放入到集合
		     listRolePower.add(rolePower);
	   }
       //批量保存
       rolePowerDao.save(listRolePower);
       
    }
  }

	@Transactional
	public void delRolePower(String roleId, String delName) {

		//权限ID字符串存在才做操作
	       if(null!=delName&&!"".equals(delName)){
	    	     //根据逗号截取
	   String [] powerIdArray=delName.substring(0, delName.length()-1).split(",");
	    	   
	  for (String powerId : powerIdArray) {
		  rolePowerDao.delRolePowerByRoleIdAndPowerId(roleId, powerId);
	}
	   
	   
	}
  }

	@Override
	public void delRolePowerByRoleIdAndPowerId(String roleId, String powerId) {
		
		rolePowerDao.delRolePowerByRoleIdAndPowerId(roleId, powerId);
	}

	@Transactional
	@Override
	public void delRoleUserByRoleId(String roleId) {
		// TODO Auto-generated method stub
		rolePowerDao.delRoleUserByRoleId(roleId);
	}
	@Transactional
	@Override
	public void delRolePowerByPowerId(String pid) {
		// TODO Auto-generated method stub
		rolePowerDao.delRolePowerByPowerId(pid);
	}
}
