package com.wellsfargo.training.cfms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="card", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "joining_fee")
	private Long joiningFee;
	
	@Column(name = "creditLimit")
	private Long creditLimit;
	
	@Column(name = "billing_cycle")
	private Long billingCycle;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "description")
	private String description;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJoiningFee() {
		return joiningFee;
	}

	public void setJoiningFee(Long joiningFee) {
		this.joiningFee = joiningFee;
	}

	public Long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Long getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(Long billingCycle) {
		this.billingCycle = billingCycle;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
