package com.mobily.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "theme")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Theme implements Serializable {

	private static final long serialVersionUID = 1L;
	/*  `theme_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
	  `name` varchar(45) NOT NULL,
	  `category_id` smallint(5) unsigned NOT NULL,
	  `description` varchar(1000) ,
	  `create_date` datetime NOT NULL,
	  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	 
	*/@Id
	@GeneratedValue
	@Column(name = "theme_id")
	private long id;

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
