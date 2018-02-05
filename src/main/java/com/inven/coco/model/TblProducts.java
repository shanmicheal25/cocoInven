package com.inven.coco.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tblProducts")
@NamedQuery(name="TblProducts.findAll", query="SELECT t FROM TblProducts t")
public class TblProducts {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ProductId")
	private int productId;
	
	private int supplierId;
	
	private int categoryId;
	
	private String productName;
	
	private int quanityPerUnit;
	
	@Column(precision=8, scale=2) 
	private float unitPrice;
	
	private int unitsInStock;
	
	private int unitsOnOrder;
	
	private int unitsReturn;
	
	private String discontinued;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String updatedBy;
	
	private LocalDateTime updatedDate;

	@Override
	public String toString() {
		return "TblProducts [productId=" + productId + ", supplierId=" + supplierId + ", categoryId=" + categoryId
				+ ", productName=" + productName + ", quanityPerUnit=" + quanityPerUnit + ", unitPrice=" + unitPrice
				+ ", unitsInStock=" + unitsInStock + ", unitsOnOrder=" + unitsOnOrder + ", unitsReturn=" + unitsReturn
				+ ", discontinued=" + discontinued + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

	public TblProducts(int supplierId, int categoryId, String productName, int quanityPerUnit, float unitPrice,
			int unitsInStock, int unitsOnOrder, int unitsReturn, String discontinued, String createdBy,
			LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate) {
		super();
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.quanityPerUnit = quanityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.unitsReturn = unitsReturn;
		this.discontinued = discontinued;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public TblProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuanityPerUnit() {
		return quanityPerUnit;
	}

	public void setQuanityPerUnit(int quanityPerUnit) {
		this.quanityPerUnit = quanityPerUnit;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public int getUnitsReturn() {
		return unitsReturn;
	}

	public void setUnitsReturn(int unitsReturn) {
		this.unitsReturn = unitsReturn;
	}

	public String getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
