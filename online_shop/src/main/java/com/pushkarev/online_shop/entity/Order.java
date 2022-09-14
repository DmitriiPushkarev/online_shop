package com.pushkarev.online_shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "online_shop.order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "online_shop.order_products"
	, joinColumns = @JoinColumn(name = "order_id")
	, inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	
    public void addProductToOrder(Product product) {
		
		if(products == null) {
			products = new ArrayList<>();
		}
		products.add(product);
	}
    
    public void addProductsToOrder(List<Product> products) {
		
		if(this.products == null) {
			this.products = new ArrayList<>(products);
		}
		this.products.addAll(products);
	}
	
	public Order() {

	}

	public Order(String name, String surname, String phoneNumber, String email, String address,
			List<Product> products) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.products = products;
	}
	
	public Order(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return orderId;
	}

	public void setId(int id) {
		this.orderId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + ", products=" + products + "]";
	}	
}
