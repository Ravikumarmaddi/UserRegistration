package com.mobily.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question_options database table.
 * 
 */
@Entity
@Table(name="question_options")
@NamedQuery(name="QuestionOption.findAll", query="SELECT q FROM QuestionOption q")
public class QuestionOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="option_id", unique=true, nullable=false)
	private int optionId;

	@Column(name="option_description", nullable=false, length=500)
	private String optionDescription;

	@Column(name="option_key", nullable=false, length=3)
	private String optionKey;

/*	//bi-directional many-to-one association to CustomerOption
	@OneToMany(mappedBy="questionOption", fetch=FetchType.EAGER)
	private List<CustomerOption> customerOptions;
*/
/*	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="question_id", nullable=false)
	private Question question;
*/
	public QuestionOption() {
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
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

/*	public List<CustomerOption> getCustomerOptions() {
		return this.customerOptions;
	}

	public void setCustomerOptions(List<CustomerOption> customerOptions) {
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

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
*/
}