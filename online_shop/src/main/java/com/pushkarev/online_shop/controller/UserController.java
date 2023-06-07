package com.pushkarev.online_shop.controller;

import com.pushkarev.online_shop.entity.Order;
import com.pushkarev.online_shop.entity.Product;
import com.pushkarev.online_shop.entity.User;
import com.pushkarev.online_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ProductService productService;

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
