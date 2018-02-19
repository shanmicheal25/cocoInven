package com.inven.coco.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the tbl_productdetails database table.
 * 
 */
@Entity
@Table(name="tbl_productdetails")
@NamedQuery(name="TblProductdetails.findAll", query="SELECT t FROM TblProductdetails t")
public class TblProductdetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productDetailsId;

	private int categoryId;

	private String createdBy;

	private LocalDateTime createdDate;

	private String productName;

	private int supplierId;

	private int unitOrder;

	private float unitPrice;

	private int unitReturn;

	private int unitRuin;
	
	private float totalPrice;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name="purchase_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime purchaseDate;

	//bi-directional many-to-one association to TblProductstock
	@ManyToOne
	@JoinColumn(name="productId", nullable=false)
	private TblProductstock tblProductstock;

	public TblProductdetails() {
	}

	public int getProductDetailsId() {
		return this.productDetailsId;
	}

	public void setProductDetailsId(int productDetailsId) {
		this.productDetailsId = productDetailsId;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getUnitOrder() {
		return this.unitOrder;
	}

	public void setUnitOrder(int unitOrder) {
		this.unitOrder = unitOrder;
	}

	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitReturn() {
		return this.unitReturn;
	}

	public void setUnitReturn(int unitReturn) {
		this.unitReturn = unitReturn;
	}

	public int getUnitRuin() {
		return this.unitRuin;
	}

	public void setUnitRuin(int unitRuin) {
		this.unitRuin = unitRuin;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public TblProductstock getTblProductstock() {
		return this.tblProductstock;
	}

	public void setTblProductstock(TblProductstock tblProductstock) {
		this.tblProductstock = tblProductstock;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}