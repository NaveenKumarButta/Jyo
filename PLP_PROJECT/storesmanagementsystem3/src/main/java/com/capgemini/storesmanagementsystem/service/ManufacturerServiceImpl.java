package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDao;
import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.factory.ManufacturerDaoManagerFactory;

public class ManufacturerServiceImpl implements ManufacturerService{

	ManufacturerDao dao=ManufacturerDaoManagerFactory.instanceOfManufacturerDaoImpl();

	@Override
	public boolean loginManufacturer(UserDetailsInfo info) {
		
		return dao.loginManufacturer(info);
	}

	@Override
	public boolean addDealer(UserDetailsInfo info1) {
		
		return dao.addDealer(info1);
	}

	@Override
	public boolean modifyDealer(UserDetailsInfo info2) {
		
		return dao.modifyDealer(info2);
	}

	@Override
	public boolean removeDealer(UserDetailsInfo info3) {
		
		return dao.removeDealer(info3);
	}

	@Override
	public boolean showDealer(UserDetailsInfo info4) {
		
		return dao.showDealer(info4);
	}

	@Override
	public boolean addProduct(ProductDetailsInfo product) {
	
		return dao.addProduct(product);
	}

	@Override
	public boolean modifyProduct(ProductDetailsInfo product1) {
		
		return dao.modifyProduct(product1);
	}

	@Override
	public boolean removeProduct(ProductDetailsInfo product2) {
		
		return dao.removeProduct(product2);
	}

	
	
	
}
