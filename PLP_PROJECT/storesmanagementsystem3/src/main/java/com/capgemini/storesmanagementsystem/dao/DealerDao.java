package com.capgemini.storesmanagementsystem.dao;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.StockDetailsInfo;

public interface DealerDao {

	public boolean loginDealer(OrderDetailsInfo info);
    public boolean makeOrder(OrderDetailsInfo info1);
	public boolean deleteOrder(OrderDetailsInfo info2);
	public boolean viewMyOrder(OrderDetailsInfo info3);
	public boolean viewMyStore(StockDetailsInfo info4);

}
