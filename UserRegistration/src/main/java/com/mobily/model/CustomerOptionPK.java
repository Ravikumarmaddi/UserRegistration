package com.mobily.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the customer_options database table.
 * 
 */
@Embeddable
public class CustomerOptionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

/*	@Column(name="question_id", insertable=false, updatable=false)
	private long questionId;
*/
	@Column(name="customer_id", insertable=false, updatable=false)
	private long customerId;

	@Column(name="option_id", insertable=false, updatable=false)
	private long optionId;

	public CustomerOptionPK() {
	}
/*	public long getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
*/	public long getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getOptionId() {
		return this.optionId;
	}
	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + (int) (optionId ^ (optionId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CustomerOptionPK))
			return false;
		CustomerOptionPK other = (CustomerOptionPK) obj;
		if (customerId != other.customerId)
			return false;
		if (optionId != other.optionId)
			return false;
		return true;
	}

}