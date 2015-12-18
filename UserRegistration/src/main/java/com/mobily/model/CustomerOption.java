package com.mobily.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The persistent class for the customer_options database table.
 * 
 */
@Entity
@Table(name = "customer_options")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "CustomerOption.findAll", query = "SELECT c FROM CustomerOption c")
public class CustomerOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerOptionPK id;

	// bi-directional many-to-one association to Customer
	// @ManyToOne
	// @JoinColumn(name="customer_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName="customer_id", insertable=false, updatable=false)
	@JsonBackReference
	private Customer customer;

	// bi-directional many-to-one association to Question
	// @ManyToOne
	// @JoinColumn(name="question_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id",referencedColumnName="question_id", insertable=false, updatable=false)
	@JsonBackReference
	private Question question;

	// bi-directional many-to-one association to QuestionOption
	// @ManyToOne
	// @JoinColumn(name="option_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "option_id",referencedColumnName="option_id", insertable=false, updatable=false)
	@JsonBackReference
	private QuestionOption questionOption;

	public CustomerOption() {
	}

	public CustomerOptionPK getId() {
		return this.id;
	}

	public void setId(CustomerOptionPK id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionOption getQuestionOption() {
		return this.questionOption;
	}

	public void setQuestionOption(QuestionOption questionOption) {
		this.questionOption = questionOption;
	}

}