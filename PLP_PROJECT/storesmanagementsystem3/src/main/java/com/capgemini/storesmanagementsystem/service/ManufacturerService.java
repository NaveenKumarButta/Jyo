package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public interface ManufacturerService {
	public boolean loginManufacturer(UserDetailsInfo info);
	public boolean addDealer(UserDetailsInfo info1);
	public boolean modifyDealer(UserDetailsInfo info2);
	public boolean removeDealer(UserDetailsInfo info3);
	public boolean showDealer(UserDetailsInfo info4);
	public boolean addProduct(ProductDetailsInfo product);
	public boolean modifyProduct(ProductDetailsInfo product1);
	public boolean removeProduct(ProductDetailsInfo product2);
}
