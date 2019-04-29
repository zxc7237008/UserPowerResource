package com.lovo.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lovo.boot.bean.RoleEntity;
import com.lovo.boot.bean.UserEntity;
import com.lovo.boot.bean.UserRoleEntity;
import com.lovo.boot.dao.RoleDao;
import com.lovo.boot.dao.RolePowerDao;
import com.lovo.boot.dao.RoleUserDao;
import com.lovo.boot.service.IRoleUserService;
@Service("roleUserService")
public class RoleUserServiceImpl implements IRoleUserService {
 

	@Autowired
	private RoleUserDao roleUserDao;
	

	
	
	
	public void andUserList(String addName, String roleId) {
		//用户ID字符串不为空
		if(null!=addName&&!"".equals(addName)){
			//去掉最后一个逗号
			addName=addName.substring(0, addName.length()-1);
		  //把逗号分隔为数组
		String[] userArray=	addName.split(",");
		//创建角色用户集合
		List<UserRoleEntity> listur=new ArrayList<>();
		
		for (String userid : userArray) {
			UserRoleEntity ur=new UserRoleEntity();		
		    RoleEntity r=new RoleEntity();
		    r.setRoleId(roleId);
		    UserEntity user=new UserEntity();
		    user.setUid(userid);
		    //把关联对象放入到中间对象
		    ur.setRole(r);
		    ur.setUser(user);
		    //把中间对象放入到集合
		    listur.add(ur);
		}		
		//批量添加中间对象
		roleUserDao.save(listur);

		}

	}

	@Transactional
	public void delUserList(String delName, String roleId) {
		       //用户ID字符串不为空
				if(null!=delName&&!"".equals(delName)){
					//去掉最后一个逗号
					delName=delName.substring(0, delName.length()-1);
				  //把逗号分隔为数组
				String[] userArray=	delName.split(",");
		     	
				if(null!=userArray&&userArray.length>0){
					//删除，根据用户ID和角色ID
					for (String userId : userArray) {
						roleUserDao.delRoleUserByUserIdAndRoleId(userId, roleId);
					}
				
				}
				
				
			}		

	}

	@Transactional
	public void delRoleUserByUserIdAndRoleId(String userId, String roleId) {
		
		roleUserDao.delRoleUserByUserIdAndRoleId(userId, roleId);
	}

	@Transactional
	@Override
	public void delRoleUserByRoleId(String roleId) {
		
		roleUserDao.delRoleUserByRoleId(roleId);
		
	}

}
