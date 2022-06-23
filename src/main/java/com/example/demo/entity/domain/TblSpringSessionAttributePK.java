package com.example.demo.entity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the tbl_spring_session_attributes database table.
 * 
 */
@Embeddable
public class TblSpringSessionAttributePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "session_primary_id", insertable = false, updatable = false)
	private String sessionPrimaryId;

	@Column(name = "attribute_name")
	private String attributeName;

	public TblSpringSessionAttributePK() {
	}

	public String getSessionPrimaryId() {
		return this.sessionPrimaryId;
	}

	public void setSessionPrimaryId(String sessionPrimaryId) {
		this.sessionPrimaryId = sessionPrimaryId;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblSpringSessionAttributePK)) {
			return false;
		}
		TblSpringSessionAttributePK castOther = (TblSpringSessionAttributePK) other;
		return this.sessionPrimaryId.equals(castOther.sessionPrimaryId) && this.attributeName.equals(castOther.attributeName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sessionPrimaryId.hashCode();
		hash = hash * prime + this.attributeName.hashCode();

		return hash;
	}
}