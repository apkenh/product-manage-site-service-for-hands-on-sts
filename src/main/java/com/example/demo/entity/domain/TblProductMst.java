package com.example.demo.entity.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tbl_product_mst database table.
 * 
 */
@Entity
@Table(name = "tbl_product_mst")
@NamedQuery(name = "TblProductMst.findAll", query = "SELECT t FROM TblProductMst t")
public class TblProductMst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_seq")
	private int productSeq;

	@Column(name = "end_of_sale")
	private Boolean endOfSale;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_of_sale_date")
	private Date endOfSaleDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enter_date")
	private Date enterDate;

	@Column(name = "enter_user")
	private String enterUser;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_color")
	private String productColor;

	@Column(name = "product_genre")
	private String productGenre;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_size_standard")
	private String productSizeStandard;

	@Column(name = "product_unit_price")
	private BigDecimal productUnitPrice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "update_user")
	private String updateUser;

	// bi-directional many-to-one association to TblProductPurchase
	@OneToMany(mappedBy = "tblProductMst")
	private List<TblProductPurchase> tblProductPurchases;

	// bi-directional many-to-one association to TblProductStockMst
	@OneToMany(mappedBy = "tblProductMst")
	private List<TblProductStockMst> tblProductStockMsts;

	public TblProductMst() {
	}

	public int getProductSeq() {
		return this.productSeq;
	}

	public void setProductSeq(int productSeq) {
		this.productSeq = productSeq;
	}

	public Object getEndOfSale() {
		return this.endOfSale;
	}

	public void setEndOfSale(Boolean endOfSale) {
		this.endOfSale = endOfSale;
	}

	public Date getEndOfSaleDate() {
		return this.endOfSaleDate;
	}

	public void setEndOfSaleDate(Date endOfSaleDate) {
		this.endOfSaleDate = endOfSaleDate;
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

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductColor() {
		return this.productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductGenre() {
		return this.productGenre;
	}

	public void setProductGenre(String productGenre) {
		this.productGenre = productGenre;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSizeStandard() {
		return this.productSizeStandard;
	}

	public void setProductSizeStandard(String productSizeStandard) {
		this.productSizeStandard = productSizeStandard;
	}

	public BigDecimal getProductUnitPrice() {
		return this.productUnitPrice;
	}

	public void setProductUnitPrice(BigDecimal productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
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

	public List<TblProductPurchase> getTblProductPurchases() {
		return this.tblProductPurchases;
	}

	public void setTblProductPurchases(List<TblProductPurchase> tblProductPurchases) {
		this.tblProductPurchases = tblProductPurchases;
	}

	public TblProductPurchase addTblProductPurchas(TblProductPurchase tblProductPurchas) {
		getTblProductPurchases().add(tblProductPurchas);
		tblProductPurchas.setTblProductMst(this);

		return tblProductPurchas;
	}

	public TblProductPurchase removeTblProductPurchas(TblProductPurchase tblProductPurchas) {
		getTblProductPurchases().remove(tblProductPurchas);
		tblProductPurchas.setTblProductMst(null);

		return tblProductPurchas;
	}

	public List<TblProductStockMst> getTblProductStockMsts() {
		return this.tblProductStockMsts;
	}

	public void setTblProductStockMsts(List<TblProductStockMst> tblProductStockMsts) {
		this.tblProductStockMsts = tblProductStockMsts;
	}

	public TblProductStockMst addTblProductStockMst(TblProductStockMst tblProductStockMst) {
		getTblProductStockMsts().add(tblProductStockMst);
		tblProductStockMst.setTblProductMst(this);

		return tblProductStockMst;
	}

	public TblProductStockMst removeTblProductStockMst(TblProductStockMst tblProductStockMst) {
		getTblProductStockMsts().remove(tblProductStockMst);
		tblProductStockMst.setTblProductMst(null);

		return tblProductStockMst;
	}

}