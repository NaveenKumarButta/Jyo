package com.capgemini.storesmanagementsystem.dto;

public class ProductDetailsInfo {

	private int productId;
	private String productName;
	private double price;
	private int warranty;
	private String productBrand;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	public void setProductBrand(String productBrand) {
		this.productBrand=getProductBrand();
	}

	public String getProductBrand() {
		
		return productBrand;
	}

}
