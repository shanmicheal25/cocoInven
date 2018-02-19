package com.inven.coco.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_purchaseorder database table.
 * 
 */
@Entity
@Table(name="tbl_purchaseorder")
@NamedQuery(name="TblPurchaseorder.findAll", query="SELECT t FROM TblPurchaseorder t")
public class TblPurchaseorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private long orderId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="total_price")
	private float totalPrice;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to TblPorderitem
	@OneToMany(mappedBy="tblPurchaseorder")
	@JsonIgnore
	private List<TblPorderitem> tblPorderitems;

	//bi-directional many-to-one association to TblCustomer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private TblCustomers tblCustomers;

	public TblPurchaseorder() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<TblPorderitem> getTblPorderitems() {
		return this.tblPorderitems;
	}

	public void setTblPorderitems(List<TblPorderitem> tblPorderitems) {
		this.tblPorderitems = tblPorderitems;
	}

	public TblPorderitem addTblPorderitem(TblPorderitem tblPorderitem) {
		getTblPorderitems().add(tblPorderitem);
		tblPorderitem.setTblPurchaseorder(this);

		return tblPorderitem;
	}

	public TblPorderitem removeTblPorderitem(TblPorderitem tblPorderitem) {
		getTblPorderitems().remove(tblPorderitem);
		tblPorderitem.setTblPurchaseorder(null);

		return tblPorderitem;
	}

	public TblCustomers getTblCustomers() {
		return this.tblCustomers;
	}

	public void setTblCustomers(TblCustomers tblCustomers) {
		this.tblCustomers = tblCustomers;
	}

}