package com.example.demo.entity.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tbl_product_stock_mst database table.
 * 
 */
@Entity
@Table(name="tbl_product_stock_mst")
@NamedQuery(name="TblProductStockMst.findAll", query="SELECT t FROM TblProductStockMst t")
public class TblProductStockMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_stock_seq")
	private int productStockSeq;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="enter_date")
	private Date enterDate;

	@Column(name="enter_user")
	private String enterUser;

	@Column(name="product_stock_quantity")
	private BigDecimal productStockQuantity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to TblProductMst
	@ManyToOne
	@JoinColumn(name="product_seq")
	private TblProductMst tblProductMst;

	public TblProductStockMst() {
	}

	public int getProductStockSeq() {
		return this.productStockSeq;
	}

	public void setProductStockSeq(int productStockSeq) {
		this.productStockSeq = productStockSeq;
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

	public BigDecimal getProductStockQuantity() {
		return this.productStockQuantity;
	}

	public void setProductStockQuantity(BigDecimal productStockQuantity) {
		this.productStockQuantity = productStockQuantity;
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

	public TblProductMst getTblProductMst() {
		return this.tblProductMst;
	}

	public void setTblProductMst(TblProductMst tblProductMst) {
		this.tblProductMst = tblProductMst;
	}

}