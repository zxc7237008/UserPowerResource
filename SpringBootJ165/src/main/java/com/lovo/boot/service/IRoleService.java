package com.lovo.boot.service;

import java.util.List;

import com.lovo.boot.bean.RoleEntity;

public interface IRoleService {
    /**
     * 添加角色
     * @param role
     * @return 
     */
	public RoleEntity savaRole(RoleEntity role);
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<RoleEntity> findAllListRole();
	
	/**
	 *根据角色id删除角色
	 * @return
	 */
	
	
	public void delete(String roleId);
}
