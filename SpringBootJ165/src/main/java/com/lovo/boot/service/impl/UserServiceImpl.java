package com.lovo.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.boot.bean.UserEntity;
import com.lovo.boot.dao.UserDAO;
import com.lovo.boot.service.IUserService;

@Service(value="userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserEntity savaUser(UserEntity user) {
		UserEntity u = userDAO.save(user);
		return u;
	}

	@Override
	public List<UserEntity> findAllUser() {
	
		return (List<UserEntity>) userDAO.findAll();
	}

	@Override
	public UserEntity getUser(String id) {
	
		return userDAO.findOne(id);
	}

	@Override
	public List<UserEntity> getUserListByRoleId(String roleId) {

		return userDAO.getUserListByRoleId(roleId);
	}

	@Override
	public List<UserEntity> getNOUserListByRoleId(List<UserEntity> roleListUser) {
		//查询出所有用户
	   List<UserEntity> listUserAll=	(List<UserEntity>) userDAO.findAll();
	   //所有-拥有=不拥有
	   
	   //拥有的为null,直接返回所有
	   if(null==roleListUser||roleListUser.isEmpty()){
		   return listUserAll;
	   }else{
		  for(int i=0;i<roleListUser.size();i++){
			  String uid=roleListUser.get(i).getUid();
			  for(int j=0;j<listUserAll.size();j++){
				  String allUid=listUserAll.get(j).getUid();
				  if(uid.equals(allUid)){
					  //删除用户
					  listUserAll.remove(j);
					  break;//跳出当前循环
				  }
			  }
		  }
	   }
	   
		return listUserAll;
	}

	@Override
	public UserEntity findByUnameAndUpasss(String uname,String upasss) {
		
		return userDAO.findByUnameAndUpasss(uname, upasss);
	}



	
	
}
