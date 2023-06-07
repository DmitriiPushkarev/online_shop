package com.pushkarev.online_shop.controller;

import com.pushkarev.online_shop.entity.Product;
import com.pushkarev.online_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

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
}
