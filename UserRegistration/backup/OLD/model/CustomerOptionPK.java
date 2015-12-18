package com.mobily.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerOptionPK  implements Serializable {
	
    @Column(name = "question_id", nullable = false)
    private long questionId;

    @Column(name = "option_id", nullable = false)
    private long optionId;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (optionId ^ (optionId >>> 32));
		result = prime * result + (int) (questionId ^ (questionId >>> 32));
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
