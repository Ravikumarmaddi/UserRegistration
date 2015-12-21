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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@Table(name = "theme", uniqueConstraints = { @UniqueConstraint(columnNames = { "theme_id" }) })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theme_id")
	private long themeId;

	private String description;

	private String name;

/*	// bi-directional many-to-one association to Customer
	// @OneToMany(mappedBy="theme")
	@OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
	@Column(nullable = true)
	@JsonManagedReference
	private Set<Customer> customers;
*/
	// bi-directional many-to-one association to ThemeCategory
	//@ManyToOne
	//@JoinColumn(name = "category_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable=true)
//	@JsonBackReference
	private ThemeCategory themeCategory;

	public Theme() {
	}

	public long getThemeId() {
		return this.themeId;
	}

	public void setThemeId(long themeId) {
		this.themeId = themeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
*/
/*	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setTheme(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setTheme(null);

		return customer;
	}
*/
	public ThemeCategory getThemeCategory() {
		return this.themeCategory;
	}

	public void setThemeCategory(ThemeCategory themeCategory) {
		this.themeCategory = themeCategory;
	}

}