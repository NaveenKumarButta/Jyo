package com.capgemini.storesmanagementsystem.factory;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDao;
import com.capgemini.storesmanagementsystem.dao.ManufacturerImpl;
import com.capgemini.storesmanagementsystem.service.ManufacturerService;
import com.capgemini.storesmanagementsystem.service.ManufacturerServiceImpl;

public class ManufacturerDaoManagerFactory {
	
		public static ManufacturerDao getManufacturerDao() {
			return new ManufacturerImpl(); 
		}

		public static ManufacturerDao instanceOfManufacturerDaoImpl() {
			ManufacturerDao dao= new ManufacturerImpl();
			return dao;
		   }

		public static ManufacturerService instanceOfManufacturerServiceImpl() {
			ManufacturerService service= new ManufacturerServiceImpl();
			return service;
		   }
		
	}

