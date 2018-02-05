package com.inven.coco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tblCategorys")
@NamedQuery(name="TblCategorys.findAll", query="SELECT t FROM TblCategorys t")
public class TblCategorys {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CategoryId")
	private int categoryId;
	
	private String categoryName;
	


	public TblCategorys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblCategorys(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	
	@Override
	public String toString() {
		return "TblCategorys [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
