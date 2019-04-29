package com.lovo.boot.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lovo.boot.bean.RolePowerEntity;

public interface RolePowerDao extends CrudRepository<RolePowerEntity, String> {

	/**
	 * 根据角色ID和权限ID删除角色权限表
	 * @param roleId 角色ID
	 * @param powerId 权限ID
	 */
	@Modifying
	@Query("delete from RolePowerEntity rp where rp.role.roleId=?1 and rp.power.pid=?2 ")
	public void delRolePowerByRoleIdAndPowerId(String roleId,String powerId);
	
	
	//根据 角色ID删除角色中间表

	@Modifying
	@Query("delete from RolePowerEntity ur where  ur.role.roleId=?1")
	public void delRoleUserByRoleId(String roleId);
	
	
	@Modifying
	@Query("delete from RolePowerEntity ur where  ur.power.pid=?1")
	public void delRolePowerByPowerId(String pid);
	
}
