package com.mobily.model;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "encrypt_key")
	private String encryptedKey;
	
	@OneToOne(mappedBy = "customer")
	 private Theme theme;
	 
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "self_description")
	private String selfDescription;

	@Column(name = "create_date")
	private String createDate;
	
	@OneToMany(mappedBy = "customer")
	 private java.util.Set<Address> addresses=new HashSet<Address>(0);


/*
	  `customer_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
	  `user_name` varchar(45) NOT NULL,
	  `password` varchar(45) NOT NULL,
	  `encrypt_key` varchar(200) NOT NULL,
	  `theme_id` smallint(5) unsigned NOT NULL,
	  `first_name` varchar(45) NOT NULL,
	  `last_name` varchar(45) NOT NULL,
	  `email` varchar(50) DEFAULT NULL,
	  `active` tinyint(1) NOT NULL DEFAULT '1',
	  `create_date` datetime NOT NULL,
	  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	  `self_description` varchar(2000) NOT NULL,
	  PRIMARY KEY (`customer_id`),
	  KEY `idx_last_name` (`last_name`),
	  CONSTRAINT `fk_customer_theme_id` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`theme_id`) ON UPDATE CASCADE

*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedKey() {
		return encryptedKey;
	}

	public void setEncryptedKey(String encryptedKey) {
		this.encryptedKey = encryptedKey;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public java.util.Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(java.util.Set<Address> addresses) {
		this.addresses = addresses;
	}

}
