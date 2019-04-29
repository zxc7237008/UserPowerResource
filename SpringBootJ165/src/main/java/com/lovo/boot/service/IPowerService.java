package com.lovo.boot.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lovo.boot.bean.PowerDto;
import com.lovo.boot.bean.PowerEntity;
import com.lovo.boot.bean.RoleEntity;

public interface IPowerService {
    /**
     * 保存权限
     * @param power
     * @return 
     */
	public PowerEntity savaPower(PowerEntity power);
	/**
	 * 获得所有权限
	 * @return
	 */
	public List<PowerEntity> getPowerList();
	
	  /**
	    * 根据角色ID查询出拥有的权限
	    * @param roleId
	    * @return
	    */
	public List<PowerEntity> findPowerListByRoleId(String roleId);
	/**
	 * 查询出该角色不拥有的权限	
	 * @param listRolePower 拥有的权限
	 * @param allListRolePower  所有的权限
	 * @return 不拥有的权限
	 */
	public List<PowerEntity>   noFindPowerListByRoleId(List<PowerEntity> listRolePower,List<PowerEntity> allListRolePower);
	/**
	 * 根据用户名和密码查询出权限集合
	 * @param userName 用户名
	 * @param password 密码
	 * @return 权限集合DTO
	 */
	public List<PowerDto>  findPowerDtoListByUserNameAndPassword(String userName,String password,String sysTag);
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<PowerEntity> findAllListPower();
	
	
	
	/**
	 * 根据权限ID删除权限
	 * @return
	 */
			
    public void delPower(String pid);
			
}
