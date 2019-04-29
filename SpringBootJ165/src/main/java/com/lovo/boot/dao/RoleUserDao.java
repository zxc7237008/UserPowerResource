package com.lovo.boot.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lovo.boot.bean.UserRoleEntity;

public interface RoleUserDao extends CrudRepository<UserRoleEntity,String>{
   /**
    * 根据用户ID和角色ID进行删除
    * @param userId 用户ID
    * @param roleId 角色ID
    */
	@Modifying
	@Query("delete from UserRoleEntity ur where ur.user.uid=?1 and ur.role.roleId=?2")
	public void delRoleUserByUserIdAndRoleId(String userId,String roleId);
	

	  /**
	    * 根据角色ID进行删除
	    * 
	    * @param roleId 角色ID
	    */
	@Modifying
	@Query("delete from UserRoleEntity ur where  ur.role.roleId=?1")
	public void delRoleUserByRoleId(String roleId);
	
}
