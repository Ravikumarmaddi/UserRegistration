package com.mobily.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OptionKey {
	
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

}
