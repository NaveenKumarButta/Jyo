package com.capgemini.storesmanagementsystem.dao;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.StoresInfo;

public interface DealerDao {

	public boolean makeOrder(OrderDetailsInfo order);

	public boolean deleteOrder(Integer orderId);

	public List<String> showAllproducts();

	public List<String> viewMyOrders(int userId);

	public List<String> viewMyStore(int storeId);

}
