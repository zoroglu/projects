package com.ent.main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractBaseEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1379675644134134365L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_timestamp")
	private Date createdTimeStamp = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_timestamp")
	@Version
	private Date updatedTimestamp;

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
}
