package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.StoresInfo;

public interface DealerService {

	public boolean makeOrder(OrderDetailsInfo order);

	public boolean deleteOrder(Integer orderId);

	public List<String> showAllproducts();

	public List<String> viewMyStore(int storeId);

	public List<String> viewMyOrders(int userId);

}
