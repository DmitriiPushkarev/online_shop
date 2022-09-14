package com.pushkarev.online_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pushkarev.online_shop.dao.ProductDAO;
import com.pushkarev.online_shop.entity.Category;
import com.pushkarev.online_shop.entity.Order;
import com.pushkarev.online_shop.entity.Product;
import com.pushkarev.online_shop.entity.User;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
		
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	@Override
	@Transactional
	public List<Category> getAllCategories() {
		return productDAO.getAllCategories();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
		
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
		
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
		productDAO.saveOrder(order);
		
	}
	
	@Override
	@Transactional
	public List<Order> getAllOrders() {
		return productDAO.getAllOrders();
	}
	
	@Override
	@Transactional
	public void saveUser(User user) {
		productDAO.saveUser(user);	
	}
	
	@Override
	@Transactional
	public User getUser(String username) {
		return productDAO.getUser(username);
	}
	
}
