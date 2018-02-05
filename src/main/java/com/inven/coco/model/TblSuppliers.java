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
@Table(name="tblSuppliers")
@NamedQuery(name="TblSuppliers.findAll", query="SELECT t FROM TblSuppliers t")
public class TblSuppliers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SupplierId")
	private int supplierId;

	private String address1;

	private String address2;

	private String city;

	private String companyName;

	private String contactName;

	private String country;

	private String fax;

	private String phone;

	private String postalCode;
	
	private String createdBy;
	
	private LocalDateTime  createdDate;
	
	private String updatedBy;
	
	private LocalDateTime  updatedDate;

	@Override
	public String toString() {
		return "TblSuppliers [supplierId=" + supplierId + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", companyName=" + companyName + ", contactName=" + contactName + ", country="
				+ country + ", fax=" + fax + ", phone=" + phone + ", postalCode=" + postalCode + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}

	public TblSuppliers(String address1, String address2, String city, String companyName, String contactName,
			String country, String fax, String phone, String postalCode, String createdBy, LocalDateTime createdDate,
			String updatedBy, LocalDateTime updatedDate) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.companyName = companyName;
		this.contactName = contactName;
		this.country = country;
		this.fax = fax;
		this.phone = phone;
		this.postalCode = postalCode;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public TblSuppliers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
