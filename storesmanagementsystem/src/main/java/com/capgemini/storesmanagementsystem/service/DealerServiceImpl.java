package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dao.DealerDao;
import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.StoresInfo;

public class DealerServiceImpl implements DealerService {

	private DealerDao dao;

	public boolean makeOrder(OrderDetailsInfo order) {
		return dao.makeOrder(order);
	}

	public boolean deleteOrder(Integer orderId) {
		return dao.deleteOrder(orderId);
	}

	public List<String> showAllproducts() {
		return dao.showAllproducts();
	}

	public List<String> viewMyStore(int storeId) {
		return dao.viewMyStore(storeId);
	}

	public List<String> viewMyOrders(int userId) {
		return dao.viewMyOrders(userId);
	}

}
