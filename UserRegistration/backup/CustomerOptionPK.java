package com.mobily.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerOptionPK  implements Serializable {
	
    @Column(name = "question_id", nullable = false)
    private int questionId;

    @Column(name = "option_id", nullable = false)
    private int optionId;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + optionId;
		result = prime * result + questionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerOptionPK other = (CustomerOptionPK) obj;
		if (optionId != other.optionId)
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}

}
