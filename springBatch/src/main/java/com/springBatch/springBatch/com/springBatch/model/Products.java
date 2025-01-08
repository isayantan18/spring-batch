package com.springBatch.springBatch.com.springBatch.model;

public class Products {
	private String productId;
	private String title;
	private String description;
	private String price;
	private String discount;
	//private String discounted_price;
	public String getProductId() {
		return productId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getPrice() {
		return price;
	}
	public String getDiscount() {
		return discount;
	}

	/*
	 * public String getDiscounted_price() { return discounted_price; }
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/*
	 * public void setDiscounted_price(String discounted_price) {
	 * this.discounted_price = discounted_price; }
	 */
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(String productId, String title, String description, String price, String discount,
			String discounted_price) {
		super();
		this.productId = productId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		//this.discounted_price = discounted_price;
	}
	/*
	 * @Override public String toString() { return "Products [productId=" +
	 * productId + ", title=" + title + ", description=" + description + ", price="
	 * + price + ", discount=" + discount + ", discounted_price=" + discounted_price
	 * + "]"; }
	 */
	
	
	
}
