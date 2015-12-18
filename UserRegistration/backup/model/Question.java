package com.mobily.model;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "question")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
/*	 `question_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
--	  `category` varchar(25) NOT NULL,
	  `question` varchar(500) NOT NULL,
	  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
*/
	@Id
	@GeneratedValue
	@Column(name = "question_id")
	private long id;

	@Column(name = "question")
	private String question;

	
	@OneToMany(mappedBy = "question")
	 private java.util.Set<Option> options=new HashSet<Option>(0);


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public java.util.Set<Option> getOptions() {
		return options;
	}

	public void setOptions(java.util.Set<Option> options) {
		this.options = options;
	}

}
