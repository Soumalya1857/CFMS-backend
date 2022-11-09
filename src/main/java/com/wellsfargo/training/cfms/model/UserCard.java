package com.wellsfargo.training.cfms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user_card", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId; // foreign to user
	
	@Column(name = "card_type")
	private String cardType; // foreign to Card
	
	@Column(name = "useable_credit_limit")
	private Long useableCreditLimit;
	
	@Column(name = "is_activated")
	private boolean activated;
	
	@Column(name = "issue_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date issueDate;
	
	@Column(name = "expiry_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date validity;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getUseableCreditLimit() {
		return useableCreditLimit;
	}

	public void setUseableCreditLimit(Long useableCreditLimit) {
		this.useableCreditLimit = useableCreditLimit;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}
	
}
