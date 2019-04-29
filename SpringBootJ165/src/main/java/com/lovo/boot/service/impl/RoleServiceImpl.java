package com.lovo.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lovo.boot.bean.RoleEntity;
import com.lovo.boot.dao.RoleDao;
import com.lovo.boot.service.IRoleService;
@Service(value="roleService")
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleDao roleDao;

	
	
	public RoleEntity savaRole(RoleEntity role) {
	
	    return	roleDao.save(role);
	}
	
	public List<RoleEntity> findAllListRole() {

		return (List<RoleEntity>) roleDao.findAll();
	}



	@Transactional
	@Override
	public void delete(String roleId) {
		// TODO Auto-generated method stub
		
		roleDao.delete(roleId);
	}

	

	

	

	

	
	
	
}
