package com.mobily.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id", unique=true, nullable=false)
	private long customerId;

	//bi-directional many-to-one association to Address
	//@OneToMany(mappedBy="customer")
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //@JoinTable(name="address", joinColumns={@JoinColumn(name="customer_id", referencedColumnName="customer_id")}, inverseJoinColumns={@JoinColumn(name="account_id", referencedColumnName="account_id")})
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", nullable = false)
	private List<Address> addresses;

	@Column(nullable=false)
	private byte active;

/*	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	private Date createDate;
*/
	@Column(length=50)
	private String email;

	@Column(name="encrypt_key", nullable=false, length=200)
	private String encryptKey;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;
	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
*/
	@Column(nullable=false, length=45)
	private String password;

	@Column(name="self_description", nullable=false, length=2000)
	private String selfDescription;

	@Column(name="user_name", nullable=false, length=45)
	private String userName;

	//bi-directional one-to-one association to Theme
	//@OneToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="theme_id", nullable=false)
	    // @JoinColumn(name="USER_ID", nullable=false)
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="theme_id", nullable=false)
	private Theme theme;

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

/*	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
*/
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

/*	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
*/
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

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
	//	address.setCustomer(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
	//	address.setCustomer(null);

		return address;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}