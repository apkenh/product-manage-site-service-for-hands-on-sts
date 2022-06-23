package com.example.demo.entity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tbl_user_mst database table.
 * 
 */
@Entity
@Table(name = "tbl_user_mst")
@NamedQuery(name = "TblUserMst.findAll", query = "SELECT t FROM TblUserMst t")
public class TblUserMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_seq")
	private int userSeq;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enter_date")
	private Date enterDate;

	@Column(name = "enter_user")
	private String enterUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "user_account")
	private String userAccount;

	@Column(name = "user_currency")
	private String userCurrency;

	@Column(name = "user_encoded_password")
	private String userEncodedPassword;

	@Column(name = "user_locale")
	private String userLocale;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_sub_menu_role")
	private String userSubMenuRole;

	@Column(name = "user_timezone")
	private String userTimezone;

	@Column(name = "user_timezone_offset")
	private String userTimezoneOffset;

	public TblUserMst() {
	}

	public int getUserSeq() {
		return this.userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
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

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserCurrency() {
		return this.userCurrency;
	}

	public void setUserCurrency(String userCurrency) {
		this.userCurrency = userCurrency;
	}

	public String getUserEncodedPassword() {
		return this.userEncodedPassword;
	}

	public void setUserEncodedPassword(String userEncodedPassword) {
		this.userEncodedPassword = userEncodedPassword;
	}

	public String getUserLocale() {
		return this.userLocale;
	}

	public void setUserLocale(String userLocale) {
		this.userLocale = userLocale;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSubMenuRole() {
		return this.userSubMenuRole;
	}

	public void setUserSubMenuRole(String userSubMenuRole) {
		this.userSubMenuRole = userSubMenuRole;
	}

	public String getUserTimezone() {
		return this.userTimezone;
	}

	public void setUserTimezone(String userTimezone) {
		this.userTimezone = userTimezone;
	}

	public String getUserTimezoneOffset() {
		return this.userTimezoneOffset;
	}

	public void setUserTimezoneOffset(String userTimezoneOffset) {
		this.userTimezoneOffset = userTimezoneOffset;
	}

}