package com.inven.coco.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_porderitem database table.
 * 
 */
@Entity
@Table(name="tbl_porderitem")
@NamedQuery(name="TblPorderitem.findAll", query="SELECT t FROM TblPorderitem t")
public class TblPorderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="item_id")
	private long itemId;

	private String description;

	private int orderLineItem_id;

	private float price;

	private int quantity;

	//bi-directional many-to-one association to TblPurchaseorder
	@ManyToOne
	@JoinColumn(name="order_id")
	private TblPurchaseorder tblPurchaseorder;

	//bi-directional many-to-one association to TblProductstock
	@ManyToOne
	@JoinColumn(name="product_id")
	private TblProductstock tblProductstock;

	public TblPorderitem() {
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderLineItem_id() {
		return this.orderLineItem_id;
	}

	public void setOrderLineItem_id(int orderLineItem_id) {
		this.orderLineItem_id = orderLineItem_id;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TblPurchaseorder getTblPurchaseorder() {
		return this.tblPurchaseorder;
	}

	public void setTblPurchaseorder(TblPurchaseorder tblPurchaseorder) {
		this.tblPurchaseorder = tblPurchaseorder;
	}

	public TblProductstock getTblProductstock() {
		return this.tblProductstock;
	}

	public void setTblProductstock(TblProductstock tblProductstock) {
		this.tblProductstock = tblProductstock;
	}

}