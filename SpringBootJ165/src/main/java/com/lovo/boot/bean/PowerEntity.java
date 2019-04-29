package com.lovo.boot.bean;

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
@Table(name="t_power")
public class PowerEntity{
    private String pid;
	private String pname;
	private String puri;
	private String sysTag;
	@JsonIgnore
    private Set<RolePowerEntity> setRolePower;
	
	public PowerEntity() {
	}


	
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "pid", unique = true, nullable = false, length = 32)
	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "pname", length = 48)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name = "puri", length = 48)
	public String getPuri() {
		return this.puri;
	}

	public void setPuri(String puri) {
		this.puri = puri;
	}

	@OneToMany(mappedBy="power")
	public Set<RolePowerEntity> getSetRolePower() {
		return setRolePower;
	}


	public void setSetRolePower(Set<RolePowerEntity> setRolePower) {
		this.setRolePower = setRolePower;
	}

   @Column(length=2)
	public String getSysTag() {
		return sysTag;
	}


	public void setSysTag(String sysTag) {
		this.sysTag = sysTag;
	}

}