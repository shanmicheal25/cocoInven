package com.inven.coco.pojo.product;

import java.util.Date;
import java.util.List;

import com.inven.coco.pojo.defaults.ResponsePojo;

public class ProductStockPojo extends ResponsePojo{

	private long productId;

	private String createdBy;

	private Date createdDate;

	private String productName;

	private int unitCount;

	private int unitReturn;

	private int unitSell;

	private String updatedBy;

	private Date updatedDate;

	private List<ProductdetailsPojo> productDetailsPojo;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}

	public int getUnitReturn() {
		return unitReturn;
	}

	public void setUnitReturn(int unitReturn) {
		this.unitReturn = unitReturn;
	}

	public int getUnitSell() {
		return unitSell;
	}

	public void setUnitSell(int unitSell) {
		this.unitSell = unitSell;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<ProductdetailsPojo> getProductDetailsPojo() {
		return productDetailsPojo;
	}

	public void setProductDetailsPojo(List<ProductdetailsPojo> productDetailsPojo) {
		this.productDetailsPojo = productDetailsPojo;
	}

	

	
	
}
