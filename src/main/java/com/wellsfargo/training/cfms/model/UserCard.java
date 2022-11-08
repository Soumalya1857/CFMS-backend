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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_card", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Getter
@Setter
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
	private Date expiryDate;
	
}
