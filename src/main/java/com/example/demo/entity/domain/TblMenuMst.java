package com.example.demo.entity.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_menu_mst database table.
 * 
 */
@Entity
@Table(name="tbl_menu_mst")
@NamedQuery(name="TblMenuMst.findAll", query="SELECT t FROM TblMenuMst t")
public class TblMenuMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_seq")
	private int menuSeq;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="enter_date")
	private Date enterDate;

	@Column(name="enter_user")
	private String enterUser;

	@Column(name="menu_code")
	private String menuCode;

	@Column(name="menu_order")
	private short menuOrder;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to TblPageRoleMst
	@OneToMany(mappedBy="tblMenuMst")
	private List<TblPageRoleMst> tblPageRoleMsts;

	public TblMenuMst() {
	}

	public int getMenuSeq() {
		return this.menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
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

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public short getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(short menuOrder) {
		this.menuOrder = menuOrder;
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

	public List<TblPageRoleMst> getTblPageRoleMsts() {
		return this.tblPageRoleMsts;
	}

	public void setTblPageRoleMsts(List<TblPageRoleMst> tblPageRoleMsts) {
		this.tblPageRoleMsts = tblPageRoleMsts;
	}

	public TblPageRoleMst addTblPageRoleMst(TblPageRoleMst tblPageRoleMst) {
		getTblPageRoleMsts().add(tblPageRoleMst);
		tblPageRoleMst.setTblMenuMst(this);

		return tblPageRoleMst;
	}

	public TblPageRoleMst removeTblPageRoleMst(TblPageRoleMst tblPageRoleMst) {
		getTblPageRoleMsts().remove(tblPageRoleMst);
		tblPageRoleMst.setTblMenuMst(null);

		return tblPageRoleMst;
	}

}