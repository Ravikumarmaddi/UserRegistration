package com.mobily.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = { "customer_id" }) })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private long customerId;

	// bi-directional many-to-one association to Address
	// @OneToMany(mappedBy="customer")
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(nullable = true)
	@JsonManagedReference
	private Set<Address> addresses;

	// bi-directional many-to-one association to Theme
	// @ManyToOne
	// @JoinColumn(name="theme_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "theme_id", nullable=true,referencedColumnName="theme_id", insertable=false, updatable=false)
	@JsonBackReference
	private Theme theme;

	// bi-directional many-to-one association to CustomerOption
	// @OneToMany(mappedBy="customer")
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(nullable = true)
	@JsonManagedReference
	private Set<CustomerOption> customerOptions;
	private byte active;

	private String email;

	@Column(name = "encrypt_key")
	private String encryptKey;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String password;

	@Column(name = "self_description")
	private String selfDescription;

	@Column(name = "user_name")
	private String userName;

	public Customer() {
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptKey() {
		return this.encryptKey;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSelfDescription() {
		return this.selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCustomer(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCustomer(null);

		return address;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Set<CustomerOption> getCustomerOptions() {
		return this.customerOptions;
	}

	public void setCustomerOptions(Set<CustomerOption> customerOptions) {
		this.customerOptions = customerOptions;
	}

	public CustomerOption addCustomerOption(CustomerOption customerOption) {
		getCustomerOptions().add(customerOption);
		customerOption.setCustomer(this);

		return customerOption;
	}

	public CustomerOption removeCustomerOption(CustomerOption customerOption) {
		getCustomerOptions().remove(customerOption);
		customerOption.setCustomer(null);

		return customerOption;
	}

}