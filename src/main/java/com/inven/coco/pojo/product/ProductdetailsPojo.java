package com.inven.coco.pojo.product;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inven.coco.common.util.LocalDateTimeDeserializer;
import com.inven.coco.common.util.LocalDateTimeSerializer;
import com.inven.coco.pojo.defaults.ResponsePojo;

public class ProductdetailsPojo extends ResponsePojo {

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

	private String updatedBy;

	private LocalDateTime updatedDate;

	
	private String purchaseDate;

	public int getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(int productDetailsId) {
		this.productDetailsId = productDetailsId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getUnitOrder() {
		return unitOrder;
	}

	public void setUnitOrder(int unitOrder) {
		this.unitOrder = unitOrder;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitReturn() {
		return unitReturn;
	}

	public void setUnitReturn(int unitReturn) {
		this.unitReturn = unitReturn;
	}

	public int getUnitRuin() {
		return unitRuin;
	}

	public void setUnitRuin(int unitRuin) {
		this.unitRuin = unitRuin;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	
}
