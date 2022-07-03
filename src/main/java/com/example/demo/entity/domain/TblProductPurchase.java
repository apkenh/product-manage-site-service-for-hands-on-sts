package com.example.demo.entity.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tbl_product_purchase database table.
 * 
 */
@Entity
@Table(name="tbl_product_purchase")
@NamedQuery(name="TblProductPurchase.findAll", query="SELECT t FROM TblProductPurchase t")
public class TblProductPurchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_purchase_seq")
	private int productPurchaseSeq;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="enter_date")
	private Date enterDate;

	@Column(name="enter_user")
	private String enterUser;

	@Column(name="product_purchase_amount")
	private BigDecimal productPurchaseAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="product_purchase_date")
	private Date productPurchaseDate;

	@Column(name="product_purchase_name")
	private String productPurchaseName;

	@Column(name="product_purchase_quantity")
	private BigDecimal productPurchaseQuantity;

	@Column(name="product_purchase_unit_price")
	private BigDecimal productPurchaseUnitPrice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to TblProductMst
	@ManyToOne
	@JoinColumn(name="product_seq")
	private TblProductMst tblProductMst;

	public TblProductPurchase() {
	}

	public int getProductPurchaseSeq() {
		return this.productPurchaseSeq;
	}

	public void setProductPurchaseSeq(int productPurchaseSeq) {
		this.productPurchaseSeq = productPurchaseSeq;
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

	public BigDecimal getProductPurchaseAmount() {
		return this.productPurchaseAmount;
	}

	public void setProductPurchaseAmount(BigDecimal productPurchaseAmount) {
		this.productPurchaseAmount = productPurchaseAmount;
	}

	public Date getProductPurchaseDate() {
		return this.productPurchaseDate;
	}

	public void setProductPurchaseDate(Date productPurchaseDate) {
		this.productPurchaseDate = productPurchaseDate;
	}

	public String getProductPurchaseName() {
		return this.productPurchaseName;
	}

	public void setProductPurchaseName(String productPurchaseName) {
		this.productPurchaseName = productPurchaseName;
	}

	public BigDecimal getProductPurchaseQuantity() {
		return this.productPurchaseQuantity;
	}

	public void setProductPurchaseQuantity(BigDecimal productPurchaseQuantity) {
		this.productPurchaseQuantity = productPurchaseQuantity;
	}

	public BigDecimal getProductPurchaseUnitPrice() {
		return this.productPurchaseUnitPrice;
	}

	public void setProductPurchaseUnitPrice(BigDecimal productPurchaseUnitPrice) {
		this.productPurchaseUnitPrice = productPurchaseUnitPrice;
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