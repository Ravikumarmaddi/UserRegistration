package com.mobily.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "address", uniqueConstraints = { @UniqueConstraint(columnNames = { "account_id" }) })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private long accountId;

	@Column(name = "address_type")
	private String addressType;

	@Column(name = "area_name")
	private String areaName;

	private String city;

	private String district;

	@Column(name = "door_num")
	private String doorNum;

	private String landmark;

	private String phone1;

	private String phone2;

	@Column(name = "postal_code")
	private String postalCode;

	private String street;

	// bi-directional many-to-one association to Customer
	// @ManyToOne
	// @JoinColumn(name="customer_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customer customer;

	public Address() {
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDoorNum() {
		return this.doorNum;
	}

	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}