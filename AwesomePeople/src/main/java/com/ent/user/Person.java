package com.ent.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;

@Entity
@Table(name="AWS_PERSON")
@SequenceGenerator(name = "SEQ",sequenceName = "aws_person_id_seq", allocationSize=1)
public class Person extends AbstractBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1439071324089692152L;

	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME",nullable=false)
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
