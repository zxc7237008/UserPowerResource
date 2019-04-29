package com.lovo.boot.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "t_role")
public class RoleEntity implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1368923952237896087L;
	@Id
    @GenericGenerator(name="roleUUID",strategy="uuid")
    @GeneratedValue(generator="roleUUID")
    @Column(length=32)
	private String roleId;
    @Column(length=48)
	private String roleName;
    @Column(length=88)
	private String roleDescribe;
    @JsonIgnore
	@OneToMany(mappedBy="role")
    private Set<UserRoleEntity> setUserRole;
//	
//	@OneToMany(mappedBy="power")
//    private Set<RolePowerEntity> setRolePower;


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleDescribe() {
		return roleDescribe;
	}


	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}


	public Set<UserRoleEntity> getSetUserRole() {
		return setUserRole;
	}


	public void setSetUserRole(Set<UserRoleEntity> setUserRole) {
		this.setUserRole = setUserRole;
	}
//
//
//	public Set<RolePowerEntity> getSetRolePower() {
//		return setRolePower;
//	}
//
//
//	public void setSetRolePower(Set<RolePowerEntity> setRolePower) {
//		this.setRolePower = setRolePower;
//	}
    
    
     
}