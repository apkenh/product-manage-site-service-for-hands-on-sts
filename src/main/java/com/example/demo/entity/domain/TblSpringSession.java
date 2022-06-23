package com.example.demo.entity.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tbl_spring_session database table.
 * 
 */
@Entity
@Table(name = "tbl_spring_session")
@NamedQuery(name = "TblSpringSession.findAll", query = "SELECT t FROM TblSpringSession t")
public class TblSpringSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "primary_id")
	private String primaryId;

	@Column(name = "creation_time")
	private BigInteger creationTime;

	@Column(name = "expiry_time")
	private BigInteger expiryTime;

	@Column(name = "last_access_time")
	private BigInteger lastAccessTime;

	@Column(name = "max_inactive_interval")
	private int maxInactiveInterval;

	@Column(name = "principal_name")
	private String principalName;

	@Column(name = "session_id")
	private String sessionId;

	// bi-directional many-to-one association to TblSpringSessionAttribute
	@OneToMany(mappedBy = "tblSpringSession")
	private List<TblSpringSessionAttribute> tblSpringSessionAttributes;

	public TblSpringSession() {
	}

	public String getPrimaryId() {
		return this.primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public BigInteger getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(BigInteger creationTime) {
		this.creationTime = creationTime;
	}

	public BigInteger getExpiryTime() {
		return this.expiryTime;
	}

	public void setExpiryTime(BigInteger expiryTime) {
		this.expiryTime = expiryTime;
	}

	public BigInteger getLastAccessTime() {
		return this.lastAccessTime;
	}

	public void setLastAccessTime(BigInteger lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public int getMaxInactiveInterval() {
		return this.maxInactiveInterval;
	}

	public void setMaxInactiveInterval(int maxInactiveInterval) {
		this.maxInactiveInterval = maxInactiveInterval;
	}

	public String getPrincipalName() {
		return this.principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public List<TblSpringSessionAttribute> getTblSpringSessionAttributes() {
		return this.tblSpringSessionAttributes;
	}

	public void setTblSpringSessionAttributes(List<TblSpringSessionAttribute> tblSpringSessionAttributes) {
		this.tblSpringSessionAttributes = tblSpringSessionAttributes;
	}

	public TblSpringSessionAttribute addTblSpringSessionAttribute(TblSpringSessionAttribute tblSpringSessionAttribute) {
		getTblSpringSessionAttributes().add(tblSpringSessionAttribute);
		tblSpringSessionAttribute.setTblSpringSession(this);

		return tblSpringSessionAttribute;
	}

	public TblSpringSessionAttribute removeTblSpringSessionAttribute(TblSpringSessionAttribute tblSpringSessionAttribute) {
		getTblSpringSessionAttributes().remove(tblSpringSessionAttribute);
		tblSpringSessionAttribute.setTblSpringSession(null);

		return tblSpringSessionAttribute;
	}

}