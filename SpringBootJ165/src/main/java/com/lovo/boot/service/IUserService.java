package com.lovo.boot.service;

import java.util.List;



import com.lovo.boot.bean.UserEntity;

public interface IUserService {
    /**
     * 保存用户
     * @param user
     */
	public UserEntity savaUser(UserEntity user);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserEntity> findAllUser();
	/**
	 * 根据ID获取用户对象
	 * @param id
	 * @return
	 */
	public UserEntity getUser(String id);
	
    /**
     * 根据角色ID查询出该角色拥有的用户
     * @param roleId
     * @return
     */

	public List<UserEntity> getUserListByRoleId(String roleId);
	/**
	 * 获得不拥有的用户
	 * @param roleListUser 拥有的用户
	 * @return
	 */
    public List<UserEntity> getNOUserListByRoleId(List<UserEntity> roleListUser);
}
