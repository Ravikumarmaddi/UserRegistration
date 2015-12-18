package com.mobily.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table(name="question")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="question_id", unique=true, nullable=false)
	private long questionId;

	@Column(nullable=false, length=500)
	private String question;

	//bi-directional many-to-one association to QuestionOption
    /*@JoinColumns ({
        @JoinColumn(name="question_id", referencedColumnName = "question_id"),
        @JoinColumn(name="option_id", referencedColumnName = "option_id")
    })*/
	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "question_id", nullable = false)
	//@OneToMany(mappedBy="question")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", nullable = false)
	private List<QuestionOption> questionOptions;

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

	public List<QuestionOption> getQuestionOptions() {
		return this.questionOptions;
	}

	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public QuestionOption addQuestionOption(QuestionOption questionOption) {
		getQuestionOptions().add(questionOption);
		return questionOption;
	}

	public QuestionOption removeQuestionOption(QuestionOption questionOption) {
		getQuestionOptions().remove(questionOption);
		return questionOption;
	}

}