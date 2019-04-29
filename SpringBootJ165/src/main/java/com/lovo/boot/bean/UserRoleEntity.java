package com.lovo.boot.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.lovo.boot.bean.UserEntity;


@Entity
@Table(name = "t_user_role")
public class UserRoleEntity {

    @Id
    @GenericGenerator(name="roleUserUUID",strategy="uuid")
    @GeneratedValue(generator="roleUserUUID")
    @Column(length=32)
	private String urId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name="role_id")
    private RoleEntity role;

	public String getUrId() {
		return urId;
	}

	public void setUrId(String urId) {
		this.urId = urId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	
	
}