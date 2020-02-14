package com.capgemini.storesmanagementsystem.dto;

public class StockDetailsInfo {

	private int productId;
	private String productName;
	private int numOfItems;
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}

	

}
