package com.mobily.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the addr database table.
 * 
 */
@Entity
@NamedQuery(name="Addr.findAll", query="SELECT a FROM Addr a")
public class Addr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String add1;

	//bi-directional many-to-one association to Employee
	//@ManyToOne
	//@JoinColumn(name="emp_id")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="emp_id")
    @JsonBackReference
private Employee employee;

	public Addr() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdd1() {
		return this.add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}