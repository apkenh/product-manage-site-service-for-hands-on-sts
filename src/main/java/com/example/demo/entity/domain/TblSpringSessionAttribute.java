package com.example.demo.entity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tbl_spring_session_attributes database table.
 * 
 */
@Entity
@Table(name = "tbl_spring_session_attributes")
@NamedQuery(name = "TblSpringSessionAttribute.findAll", query = "SELECT t FROM TblSpringSessionAttribute t")
public class TblSpringSessionAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblSpringSessionAttributePK id;

	@Column(name = "attribute_bytes")
	private byte[] attributeBytes;

	// bi-directional many-to-one association to TblSpringSession
	@ManyToOne
	@JoinColumn(name = "session_primary_id")
	@MapsId("sessionPrimaryId")
	private TblSpringSession tblSpringSession;

	public TblSpringSessionAttribute() {
	}

	public TblSpringSessionAttributePK getId() {
		return this.id;
	}

	public void setId(TblSpringSessionAttributePK id) {
		this.id = id;
	}

	public Object getAttributeBytes() {
		return this.attributeBytes;
	}

	public void setAttributeBytes(byte[] attributeBytes) {
		this.attributeBytes = attributeBytes;
	}

	public TblSpringSession getTblSpringSession() {
		return this.tblSpringSession;
	}

	public void setTblSpringSession(TblSpringSession tblSpringSession) {
		this.tblSpringSession = tblSpringSession;
	}

}