package com.inven.coco.pojo.order;

import com.inven.coco.model.TblProductstock;
import com.inven.coco.model.TblPurchaseorder;

public class PorderItemPojo {

	
	private int itemId;

	private String description;

	private int orderLineItem_id;

	private float price;

	private int quantity;

	private TblPurchaseorder tblPurchaseorder;

	private TblProductstock tblProductstock;
	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderLineItem_id() {
		return orderLineItem_id;
	}

	public void setOrderLineItem_id(int orderLineItem_id) {
		this.orderLineItem_id = orderLineItem_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TblPurchaseorder getTblPurchaseorder() {
		return tblPurchaseorder;
	}

	public void setTblPurchaseorder(TblPurchaseorder tblPurchaseorder) {
		this.tblPurchaseorder = tblPurchaseorder;
	}

	public TblProductstock getTblProductstock() {
		return tblProductstock;
	}

	public void setTblProductstock(TblProductstock tblProductstock) {
		this.tblProductstock = tblProductstock;
	}
	
	
}
