package com.lovo.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lovo.boot.bean.UserEntity;


public interface UserDAO extends CrudRepository<UserEntity, String>{
    /**
     * 根据角色ID查询出该角色拥有的用户
     * @param roleId
     * @return
     */
	@Query("select ur.user from UserRoleEntity ur where ur.role.roleId=?1")
	public List<UserEntity> getUserListByRoleId(String roleId);
   /**
    * 根据角色ID查询出该角色不拥有的用户
    * @param roleId
    * @return
    */
	@Query("select ur.user from UserRoleEntity ur where ur.role.roleId<>?1")
	public List<UserEntity> getNOUserListByRoleId(String roleId);

}
