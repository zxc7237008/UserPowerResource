package com.lovo.boot.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "t_user")
public class UserEntity{

	

	private String uid;
	private String uname;
	private String upasss;
	private String utel;
	private String umaildox;
	
	@Column(name = "utel", length = 48)
    public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}
	@Column(name = "umaildox", length = 48)
	public String getUmaildox() {
		return umaildox;
	}

	public void setUmaildox(String umaildox) {
		this.umaildox = umaildox;
	}

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "uid", unique = true, nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "uname", length = 48)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "upasss", length = 48)
	public String getUpasss() {
		return this.upasss;
	}

	public void setUpasss(String upasss) {
		this.upasss = upasss;
	}
//	@OneToMany(mappedBy="user")
//	public Set<UserRoleEntity> getSetUserRole() {
//		return setUserRole;
//	}
//
//	public void setSetUserRole(Set<UserRoleEntity> setUserRole) {
//		this.setUserRole = setUserRole;
//	}

}