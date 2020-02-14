package com.capgemini.storesmanagementsystem.factory;

import com.capgemini.storesmanagementsystem.dao.DealerDao;
import com.capgemini.storesmanagementsystem.dao.DealerImpl;
import com.capgemini.storesmanagementsystem.service.DealerService;
import com.capgemini.storesmanagementsystem.service.DealerServiceImpl;

public class DealerDaoManagerFactory {

	public static DealerDao getDealerDao() {
		return new DealerImpl(); 
	}

	public static DealerDao instanceOfDealerDaoImpl() {
		DealerDao dao= new DealerImpl();
		return dao;
	   }

	public static DealerService instanceOfDealerServiceImpl() {
		DealerService service= new DealerServiceImpl();
		return service;
	   }

}


