package com.lovo.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.lovo.boot.bean.PowerEntity;

public interface PowerDao extends CrudRepository<PowerEntity, String> {
   /**
    * 根据角色ID查询出拥有的权限
    * @param roleId
    * @return
    */
	@Query("select rp.power from RolePowerEntity rp where rp.role.roleId=?1")
	public List<PowerEntity> findPowerListByRoleId(String roleId);
	
	@Query(value="select u.uname  ,p.puri from t_user u LEFT JOIN t_user_role ur on u.uid=ur.user_id "+
                     "  LEFT JOIN t_role r on r.role_id=ur.role_id " +
                     "  LEFT JOIN t_role_power rp on rp.rid=r.role_id "+
                     "  LEFT JOIN t_power p on p.pid=rp.pid "+
                     "  where u.uname=?1 and u.upasss=?2 and p.sys_tag=?3",nativeQuery=true)
	public List<Object[]>  findPowerDtoListByUserNameAndPassword(String userName,String password,String sysTag);
	
	
	//根据权限ID删除权限

		@Modifying
		@Query("delete from PowerEntity pe where  pe.pid=?1")
		public void delPower(String pid);
		
		
}
