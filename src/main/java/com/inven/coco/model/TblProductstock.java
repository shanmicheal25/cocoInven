package com.inven.coco.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the tbl_productstock database table.
 * 
 */
@Entity
@Table(name="tbl_productstock")
@NamedQuery(name="TblProductstock.findAll", query="SELECT t FROM TblProductstock t")
public class TblProductstock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;

	private String createdBy;

	private LocalDateTime createdDate;

	private String productName;

	private int unitCount;

	private int unitReturn;

	private int unitSell;

	private String updatedBy;

	private LocalDateTime updatedDate;

	//bi-directional many-to-one association to TblProductdetail
	@OneToMany(mappedBy="tblProductstock", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TblProductdetails> tblProductdetails;
	
	//bi-directional many-to-one association to TblPorderitem
	@OneToMany(mappedBy="tblProductstock", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TblPorderitem> tblPorderitems;

	public TblProductstock() {
		super();
	}
	
	public TblProductstock(String productName, int unitCount, int unitReturn, int unitSell,
			List<TblProductdetails> tblProductdetails) {
		super();
		this.productName = productName;
		this.unitCount = unitCount;
		this.unitReturn = unitReturn;
		this.unitSell = unitSell;
		this.tblProductdetails = tblProductdetails;
	}


	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public int getUnitCount() {
		return this.unitCount;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}

	public int getUnitReturn() {
		return this.unitReturn;
	}

	public void setUnitReturn(int unitReturn) {
		this.unitReturn = unitReturn;
	}

	public int getUnitSell() {
		return this.unitSell;
	}

	public void setUnitSell(int unitSell) {
		this.unitSell = unitSell;
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

	public List<TblProductdetails> getTblProductdetails() {
		return this.tblProductdetails;
	}

	public void setTblProductdetails(List<TblProductdetails> tblProductdetails) {
		this.tblProductdetails = tblProductdetails;
	}

	public TblProductdetails addTblProductdetail(TblProductdetails tblProductdetail) {
		getTblProductdetails().add(tblProductdetail);
		tblProductdetail.setTblProductstock(this);

		return tblProductdetail;
	}

	public TblProductdetails removeTblProductdetail(TblProductdetails tblProductdetail) {
		getTblProductdetails().remove(tblProductdetail);
		tblProductdetail.setTblProductstock(null);

		return tblProductdetail;
	}

	public List<TblPorderitem> getTblPorderitems() {
		return tblPorderitems;
	}

	public void setTblPorderitems(List<TblPorderitem> tblPorderitems) {
		this.tblPorderitems = tblPorderitems;
	}
	
	

}