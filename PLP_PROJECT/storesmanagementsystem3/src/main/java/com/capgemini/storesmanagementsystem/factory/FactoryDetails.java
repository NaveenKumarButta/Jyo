package com.capgemini.storesmanagementsystem.factory;

import com.capgemini.storesmanagementsystem.dao.AdminDao;
import com.capgemini.storesmanagementsystem.dao.AdminDaoImpl;
import com.capgemini.storesmanagementsystem.dao.DealerDao;
import com.capgemini.storesmanagementsystem.dao.DealerImpl;
import com.capgemini.storesmanagementsystem.dao.ManufacturerDao;
import com.capgemini.storesmanagementsystem.dao.ManufacturerImpl;
import com.capgemini.storesmanagementsystem.service.AdminService;
import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;
import com.capgemini.storesmanagementsystem.service.DealerService;
import com.capgemini.storesmanagementsystem.service.DealerServiceImpl;
import com.capgemini.storesmanagementsystem.service.ManufacturerService;
import com.capgemini.storesmanagementsystem.service.ManufacturerServiceImpl;

public class FactoryDetails {

		 private FactoryDetails() {
			 
		 }
		 
		   public static AdminDao objectAdminDao() {
			   AdminDao adao = new AdminDaoImpl();
			   return adao;
		   }
			
		   public static AdminService objectAdminService() {
			   AdminService sDAO = new AdminServiceImpl();
			   return sDAO;
		   }
			
			public static ManufacturerDao objectManufacturerDAO() {
				ManufacturerDao daoc = new ManufacturerImpl();
				return daoc;
			}
			
			public static ManufacturerService objectManufactureServices() {
				ManufacturerService conServ = new ManufacturerServiceImpl();
				return conServ;
			}
			
			public static DealerDao objectDealerDAO() {
				DealerDao DAOc = new DealerImpl();
				return DAOc;
			}
			
			public static DealerService objectDealerServices() {
				DealerService custServ = new DealerServiceImpl();
				return custServ;
			}
			
}
