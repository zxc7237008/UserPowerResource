package com.lovo.boot.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lovo.boot.bean.RoleEntity;

public interface RoleDao  extends CrudRepository<RoleEntity, String>{

	//根据角色ID删除角色

	@Modifying
	@Query("delete from RoleEntity re where  re.roleId=?1")
	public void delRole(String roleId);
	
	
	
}
