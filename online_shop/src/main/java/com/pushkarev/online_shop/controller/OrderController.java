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
public class OrderController {

	private List<Product> basket;
	
	@Autowired
	private ProductService productService;

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
}