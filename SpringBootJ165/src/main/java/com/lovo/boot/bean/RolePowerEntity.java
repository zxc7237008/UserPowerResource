package com.lovo.boot.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="t_role_power")
public class RolePowerEntity {

	

	private String rpid;

   private RoleEntity role;

   private PowerEntity power;

	
	public RolePowerEntity() {
	}



	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rpid", unique = true, nullable = false, length = 32)
	public String getRpid() {
		return this.rpid;
	}

	public void setRpid(String rpid) {
		this.rpid = rpid;
	}

	@ManyToOne
	@JoinColumn(name="rid")
	public RoleEntity getRole() {
		return role;
	}


	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name="pid")
	public PowerEntity getPower() {
		return power;
	}


	public void setPower(PowerEntity power) {
		this.power = power;
	}

	

}