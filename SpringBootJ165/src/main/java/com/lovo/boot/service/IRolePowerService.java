package com.lovo.boot.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IRolePowerService {

	/**
	 * 保存角色权限
	 * @param roleId 角色ID
	 * @param addName 权限ID字符串
	 */
	public void savaRolePower(String roleId,String addName);
	
	/**
	 * 删除角色权限
	 * @param roleId 角色ID
	 * @param delName 权限ID字符串
	 */
	public void delRolePower(String roleId,String delName);
	

	/**
	 * 根据角色ID和权限ID删除角色权限表
	 * @param roleId 角色ID
	 * @param powerId 权限ID
	 */
	
	public void delRolePowerByRoleIdAndPowerId(String roleId,String powerId);
	
	
	
	public void delRoleUserByRoleId(String roleId);
	
	public void delRolePowerByPowerId(String pid);
}
