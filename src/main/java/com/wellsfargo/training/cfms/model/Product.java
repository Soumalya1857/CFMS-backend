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
@Table(name="product", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_id")
	private Long productId;
	
	@Column(name = "price")
	private Long price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_img")
	private String[] images;
	
	@Column(name = "cost")
	private Long cost;
	
	@Column(name = "emi_starting")
	private Long emiStarting;
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String[] getimages() {
		return images;
	}

	public void setimages(String[] images) {
		this.images = images;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Long getEmiStarting() {
		return emiStarting;
	}

	public void setEmiStarting(Long emiStarting) {
		this.emiStarting = emiStarting;
	}

	
	
}
