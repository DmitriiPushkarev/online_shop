package com.pushkarev.online_shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pushkarev.online_shop.entity.Order;
import com.pushkarev.online_shop.entity.Product;
import com.pushkarev.online_shop.entity.User;
import com.pushkarev.online_shop.service.ProductService;

@Controller
public class ShopController {

	private List<Product> basket;
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String showAllProducts(Model model) {

		List<Product> allProducts = productService.getAllProducts();
		model.addAttribute("allProducts", allProducts);

		return "all-products";
	}

	@RequestMapping("/addNewProduct")
	public String addNewProduct(Model model) {

		Product product = new Product();

		model.addAttribute("product", product);

		return "product-info";
	}

	@RequestMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {

		productService.saveProduct(product);

		return "redirect:/";
	}

	@RequestMapping("/updateInfo")
	public String updateProduct(@RequestParam("productId") int id, Model model) {

		Product product = productService.getProduct(id);

		model.addAttribute("product", product);
				
		return "product-info";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id) {

		productService.deleteProduct(id);

		return "redirect:/";
	}

	@RequestMapping("/addProductToBasket")
	public String addProductToBasket(@RequestParam("productId") int id, Model model) {

		if (basket == null) {
			basket = new ArrayList<>();
		}

		basket.add(productService.getProduct(id));

		return "redirect:/";
	}

	@RequestMapping("/deleteProductFromBasket")
	public String deleteProductFromBasket(@RequestParam("productId") int id) {

		basket.remove(id);

		return "redirect:/basket";
	}

	@RequestMapping("/basket")
	public String showBasket(Model model) {

		model.addAttribute("basket", basket);

		return "basket";
	}

	@RequestMapping("/addNewOrder")
	public String addNewOrder(Model model) {

		Order order = new Order(basket);

		model.addAttribute("order", order);

		return "order";
	}

	@RequestMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order) {

		order.setProducts(basket);

		productService.saveOrder(order);

		return "redirect:/";
	}

	@RequestMapping("/showAdminPanel")
	public String showAdminPanel(Model model) {

		List<Product> allProducts = productService.getAllProducts();
		model.addAttribute("allProducts", allProducts);

		List<Order> allOrders = productService.getAllOrders();
		model.addAttribute("allOrders", allOrders);

		return "admin-panel";
	}

	@RequestMapping("/login")
	public String login() {

		return "login";
	}

	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, @RequestParam("username") String username, Model model) {

		if (productService.getUser(username) == null) {
			productService.saveUser(user);
		} else {
			model.addAttribute("usernameError", "A user with the same name already exists");
			return "registration";
		}

		return "redirect:/";
	}

	@RequestMapping("/registration")
	public String registration(Model model) {

		User user = new User();

		model.addAttribute("user", user);

		return "registration";
	}
	
	@RequestMapping("/logout")
	public String logout() {

		return "logout";
	}

}
