package com.pushkarev.online_shop.dao;

import java.util.List;

import com.pushkarev.online_shop.entity.Category;
import com.pushkarev.online_shop.entity.Order;
import com.pushkarev.online_shop.entity.Product;
import com.pushkarev.online_shop.entity.User;

public interface ProductDAO {
	
	public List<Product> getAllProducts();

	public void saveProduct(Product product);

	public Product getProduct(int id);

	public void deleteProduct(int id);

	public void saveOrder(Order order);
	
	public List<Order> getAllOrders();

	public void saveUser(User user);
	
	public User getUser(String username);

	List<Category> getAllCategories();
}
