package com.pushkarev.online_shop.dao;

import java.util.List;

import com.pushkarev.online_shop.entity.Order;

public interface OrderDAO {

	public void saveOrder(Order order);

	public List<Order> getAllOrders();
}
