package com.mobily.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
/*	
	  `account_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
	  `customer_id` smallint(5) unsigned NOT NULL,
	  `address_type` varchar(15) NOT NULL,  -- Office, Branch-1, Branch-2, 
	  `door_num` varchar(50) NOT NULL,
	  `landmark` varchar(150) DEFAULT NULL,
	  `street` varchar(50) DEFAULT NULL,
	  `district` varchar(20) NOT NULL,
	  `city_id` smallint(5) unsigned NOT NULL,
	  `postal_code` varchar(10) DEFAULT NULL,
	  `phone1` varchar(20) NOT NULL,
	  `phone2` varchar(20),
	  `location` geometry NOT NULL,
	  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

*/
	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private long id;

	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "door_num")
	private String doorNum;

	@Column(name = "landmark")
	private String landmark;

	@Column(name = "street")
	private String street;

	@Column(name = "area_name")
	private String areaName;

	@Column(name = "district")
	private String district;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "phone2")
	private String phone2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getDoorNum() {
		return doorNum;
	}

	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


}
