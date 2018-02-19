package com.inven.coco.pojo.order;

import java.util.Date;
import java.util.List;

import com.inven.coco.pojo.details.CustomerPojo;

public class PurchaseOrderPojo {

	private int orderId;
	private String createdBy;
	private Date createdDate;

	private Date orderDate;

	private float totalPrice;

	private String updatedBy;

	private Date updatedDate;

	private List<PorderItemPojo> porderItemPojo;
	
	private CustomerPojo customerPojo;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<PorderItemPojo> getPorderItemPojo() {
		return porderItemPojo;
	}

	public void setPorderItemPojo(List<PorderItemPojo> porderItemPojo) {
		this.porderItemPojo = porderItemPojo;
	}

	public CustomerPojo getCustomerPojo() {
		return customerPojo;
	}

	public void setCustomerPojo(CustomerPojo customerPojo) {
		this.customerPojo = customerPojo;
	}

	
	
}
