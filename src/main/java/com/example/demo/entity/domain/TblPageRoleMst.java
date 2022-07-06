package com.example.demo.entity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tbl_page_role_mst database table.
 * 
 */
@Entity
@Table(name = "tbl_page_role_mst")
@NamedQuery(name = "TblPageRoleMst.findAll", query = "SELECT t FROM TblPageRoleMst t")
public class TblPageRoleMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "page_role_seq")
	private int pageRoleSeq;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enter_date")
	private Date enterDate;

	@Column(name = "enter_user")
	private String enterUser;

	@Column(name = "menu_display")
	private boolean menuDisplay;

	@Column(name = "menu_order")
	private short menuOrder;

	@Column(name = "page_code")
	private String pageCode;

	@Column(name = "page_role")
	private String pageRole;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "update_user")
	private String updateUser;

	// bi-directional many-to-one association to TblMenuMst
	@ManyToOne
	@JoinColumn(name = "menu_seq")
	private TblMenuMst tblMenuMst;

	public TblPageRoleMst() {
	}

	public int getPageRoleSeq() {
		return this.pageRoleSeq;
	}

	public void setPageRoleSeq(int pageRoleSeq) {
		this.pageRoleSeq = pageRoleSeq;
	}

	public Date getEnterDate() {
		return this.enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getEnterUser() {
		return this.enterUser;
	}

	public void setEnterUser(String enterUser) {
		this.enterUser = enterUser;
	}

	public boolean getMenuDisplay() {
		return this.menuDisplay;
	}

	public void setMenuDisplay(boolean menuDisplay) {
		this.menuDisplay = menuDisplay;
	}

	public short getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(short menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getPageCode() {
		return this.pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getPageRole() {
		return this.pageRole;
	}

	public void setPageRole(String pageRole) {
		this.pageRole = pageRole;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public TblMenuMst getTblMenuMst() {
		return this.tblMenuMst;
	}

	public void setTblMenuMst(TblMenuMst tblMenuMst) {
		this.tblMenuMst = tblMenuMst;
	}

}