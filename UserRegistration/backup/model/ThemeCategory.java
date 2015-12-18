package com.mobily.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "theme_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ThemeCategory implements Serializable {

	private static final long serialVersionUID = 1L;

/*	
	`category_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
	  `parent_category_id` smallint(5) unsigned,
	  `name` varchar(45) NOT NULL,
	  `description` varchar(1000) ,
	  `create_date` datetime NOT NULL,
	  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	 
*/	
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private long id;
	
	@OneToOne(mappedBy = "theme_category")
	 private ThemeCategory parentCategory;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "last_update")
	private Date lastUpdate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ThemeCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ThemeCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
