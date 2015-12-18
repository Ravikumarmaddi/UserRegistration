package com.mobily.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@Table(name="theme")
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="theme_id", unique=true, nullable=false)
	private long themeId;

/*	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	private Date createDate;
*/
	@Column(length=1000)
	private String description;

/*	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
*/
	@Column(nullable=false, length=45)
	private String name;

/*	//bi-directional many-to-one association to ThemeCategory
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="category_id", nullable=false)
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	private ThemeCategory themeCategory;
*/
	@Column(name="category_id", unique=true, nullable=false)
	private long   categoryId;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	/*//bi-directional one-to-one association to Customer
	@OneToOne(mappedBy="theme", fetch=FetchType.LAZY)
	private Customer customer;
*/
	public Theme() {
	}

	public long getThemeId() {
		return this.themeId;
	}

	public void setThemeId(long themeId) {
		this.themeId = themeId;
	}

/*	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
*/
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public ThemeCategory getThemeCategory() {
		return this.themeCategory;
	}

	public void setThemeCategory(ThemeCategory themeCategory) {
		this.themeCategory = themeCategory;
	}
*/
/*	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
*/
}