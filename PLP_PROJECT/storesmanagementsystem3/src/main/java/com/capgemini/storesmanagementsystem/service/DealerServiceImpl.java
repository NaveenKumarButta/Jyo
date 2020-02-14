package com.capgemini.storesmanagementsystem.service;

import com.capgemini.storesmanagementsystem.dao.DealerDao;
import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.StockDetailsInfo;
import com.capgemini.storesmanagementsystem.factory.DealerDaoManagerFactory;

public class DealerServiceImpl implements DealerService{
	DealerDao dao=DealerDaoManagerFactory.instanceOfDealerDaoImpl();

	@Override
	public boolean loginDealer(OrderDetailsInfo info) {
		
		return dao.loginDealer(info) ;
	}

	@Override
	public boolean makeOrder(OrderDetailsInfo info1) {
		
		return dao.makeOrder(info1);
	}

	@Override
	public boolean deleteOrder(OrderDetailsInfo info2) {
		
		return dao.deleteOrder(info2);
	}

	@Override
	public boolean viewMyOrder(OrderDetailsInfo info3) {
		
		return dao.viewMyOrder(info3);
	}

	@Override
	public boolean viewMyStore(StockDetailsInfo info4) {
		
		return dao.viewMyStore(info4);
	}

}
