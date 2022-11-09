package com.wellsfargo.training.cfms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="product", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cost")
	private Long cost;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "number_of_emis")
	private Long numberOfEmis;
	
	public Long getNumberOfEmis() {
		return numberOfEmis;
	}

	public void setNumberOfEmis(Long numberOfEmis) {
		this.numberOfEmis = numberOfEmis;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "image")
	private String image;

	public String getImage() {
		return image;
	}

	public void setImages(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
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
	
}
