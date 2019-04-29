package com.lovo.boot.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IRoleUserService {
    /**
     * 添加用户角色
     * @param addName 用户id字符串
     */
	public void andUserList(String addName,String roleId);
	
    /**
     * 删除用户角色
     * @param delName 用户id字符串
     */
	public void delUserList(String delName,String roleId);
	
	
	
	/**
	    * 根据用户ID和角色ID进行删除
	    * @param userId 用户ID
	    * @param roleId 角色ID
	    */
		
		public void delRoleUserByUserIdAndRoleId(String userId,String roleId);
		
		

		
		public void delRoleUserByRoleId(String roleId);
		
	
}
