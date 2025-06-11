package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=500)
	private String title;
	
	@Column(length=1000)
	private String description;
	
	private int stock;
	
	private String image;
	
	private String category;
	
	private double price;
	
	private int discount;
	
	private double discountPrice;
	
	private boolean isActive;
	
	public Product() {
		super();
	}

	public Product(Integer id, String title, String description, int stock, String image,
			String category, double price, int discount, double discountPrice, boolean isActive) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.stock = stock;
		this.image = image;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.discountPrice = discountPrice;	
		this.isActive = isActive;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double originalPrice) {
		this.discountPrice = originalPrice;
	}

}
