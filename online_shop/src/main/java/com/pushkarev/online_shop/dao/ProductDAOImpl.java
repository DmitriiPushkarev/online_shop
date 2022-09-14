package com.pushkarev.online_shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pushkarev.online_shop.entity.Category;
import com.pushkarev.online_shop.entity.Order;
import com.pushkarev.online_shop.entity.Product;
import com.pushkarev.online_shop.entity.User;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Category> query = session.createQuery("from Category", Category.class);
		
		List<Category> allCategories = query.getResultList();
				
		return allCategories;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Product> query = session.createQuery("from Product", Product.class);
		
		List<Product> allProducts = query.getResultList();
				
		return allProducts;
	}

	@Override
	public void saveProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(product);
	}

	@Override
	public Product getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();

		Product product = session.get(Product.class, id);

		return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Product> query = session.createQuery("delete from Product " + "where id =:productId");
		
		query.setParameter("productId", id);
		
		query.executeUpdate();
	}

	@Override
	public void saveOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(order);
	}
	
	@Override
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createQuery("from Order", Order.class);
		
		List<Order> allOrder = query.getResultList();
				
		return allOrder;
	}
	
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(user);
	}
	
	@Override
	public User getUser(String username) {
		Session session = sessionFactory.getCurrentSession();

		User user = session.get(User.class, username);

		return user;
	}
}
