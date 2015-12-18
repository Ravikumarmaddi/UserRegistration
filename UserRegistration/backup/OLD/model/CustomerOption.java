package com.mobily.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * The persistent class for the customer_options database table.
 * 
 */
@Entity
@Table(name="customer_options")
@NamedQuery(name="CustomerOption.findAll", query="SELECT c FROM CustomerOption c")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerOptionPK id;

	public CustomerOption() {
	}

	public CustomerOptionPK getId() {
		return this.id;
	}

	public void setId(CustomerOptionPK id) {
		this.id = id;
	}

}