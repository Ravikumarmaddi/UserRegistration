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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the question_options database table.
 * 
 */
@Entity
@Table(name="question_options", uniqueConstraints = {@UniqueConstraint(columnNames = {"option_id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="QuestionOption.findAll", query="SELECT q FROM QuestionOption q")
public class QuestionOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="option_id")
	private long optionId;

	@Column(name="option_description")
	private String optionDescription;

	@Column(name="option_key")
	private String optionKey;

/*	//bi-directional many-to-one association to CustomerOption
	@OneToMany(mappedBy="questionOption", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<CustomerOption> customerOptions;
*/
	//bi-directional many-to-one association to Question
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id", nullable=true)
	@JsonBackReference
	private Question question;

	public QuestionOption() {
	}

	public long getOptionId() {
		return this.optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public String getOptionDescription() {
		return this.optionDescription;
	}

	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	public String getOptionKey() {
		return this.optionKey;
	}

	public void setOptionKey(String optionKey) {
		this.optionKey = optionKey;
	}

/*	public Set<CustomerOption> getCustomerOptions() {
		return this.customerOptions;
	}

	public void setCustomerOptions(Set<CustomerOption> customerOptions) {
		this.customerOptions = customerOptions;
	}

	public CustomerOption addCustomerOption(CustomerOption customerOption) {
		getCustomerOptions().add(customerOption);
		customerOption.setQuestionOption(this);

		return customerOption;
	}

	public CustomerOption removeCustomerOption(CustomerOption customerOption) {
		getCustomerOptions().remove(customerOption);
		customerOption.setQuestionOption(null);

		return customerOption;
	}
*/
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}