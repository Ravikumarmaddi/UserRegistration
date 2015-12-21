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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table(name = "question", uniqueConstraints = { @UniqueConstraint(columnNames = { "question_id" }) })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id")
	private long questionId;

	private String question;

	/*
	 * //bi-directional many-to-one association to CustomerOption
	 * //@OneToMany(mappedBy="question")
	 * 
	 * @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade =
	 * CascadeType.ALL)
	 * 
	 * @Column(nullable = true)
	 * 
	 * @JsonManagedReference private Set<CustomerOption> customerOptions;
	 */
	// bi-directional many-to-one association to QuestionOption
	// @OneToMany(mappedBy="question")
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column(nullable = true)
	@JsonManagedReference
	private Set<QuestionOption> questionOptions;

	public Question() {
	}

	public long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	/*
	 * public Set<CustomerOption> getCustomerOptions() { return
	 * this.customerOptions; }
	 * 
	 * public void setCustomerOptions(Set<CustomerOption> customerOptions) {
	 * this.customerOptions = customerOptions; }
	 * 
	 * public CustomerOption addCustomerOption(CustomerOption customerOption) {
	 * getCustomerOptions().add(customerOption);
	 * customerOption.setQuestion(this);
	 * 
	 * return customerOption; }
	 * 
	 * public CustomerOption removeCustomerOption(CustomerOption customerOption)
	 * { getCustomerOptions().remove(customerOption);
	 * customerOption.setQuestion(null);
	 * 
	 * return customerOption; }
	 */
	public Set<QuestionOption> getQuestionOptions() {
		return this.questionOptions;
	}

	public void setQuestionOptions(Set<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public QuestionOption addQuestionOption(QuestionOption questionOption) {
		getQuestionOptions().add(questionOption);
		questionOption.setQuestion(this);

		return questionOption;
	}

	public QuestionOption removeQuestionOption(QuestionOption questionOption) {
		getQuestionOptions().remove(questionOption);
		questionOption.setQuestion(null);

		return questionOption;
	}

}