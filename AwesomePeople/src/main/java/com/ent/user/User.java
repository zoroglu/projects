package com.ent.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ent.main.AbstractBaseEntity;

@Entity
@Table(name="USR_USER")
@SequenceGenerator(name="SEQ",sequenceName="usr_user_id_seq", allocationSize=1)
public class User extends AbstractBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3972404902557087971L;
	
	
	@Column(name="USER_NAME",nullable=false)
	private String userName;
	
	@Column(name="EMAIL",nullable=false)
	private String email;
	
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@Column(name="ACTIVE", nullable=false)
	private boolean active;
	
	@Column(name="ACTIVATION_HASH", nullable=false)
	private String activationHash;
	
	@OneToOne
	private Person person;

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getActivationHash() {
		return activationHash;
	}

	public void setActivationHash(String activationHash) {
		this.activationHash = activationHash;
	}

}
