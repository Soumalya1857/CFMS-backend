package com.wellsfargo.training.cfms.model;

import java.sql.Date;

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
@Table(name="transaction_info", uniqueConstraints = @UniqueConstraint(columnNames = "transaction_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TransactionInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Long transactionId;
	
	@Column(name = "user_id")
	private Long amountPaid; // foreign to user
	
	@Column(name = "product_id")
	private Long productId; // foreign to Card
	
	@Column(name = "user_card_id")
	private Long userCardId;
	
	@Column(name = "is_outstanding")
	private boolean isOutstanding;
	
	@Column(name = "is_completed")
	private boolean isCompleted;
	
	@Column(name = "user_id")
	private Long userId ;
	
	@Column(name = "date")
	private Date date;
	
}
