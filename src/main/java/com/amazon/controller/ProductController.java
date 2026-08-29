package com.amazon.controller;

import com.amazon.model.Product;
import com.amazon.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ProductController {
    private ProductService productService = new ProductService();
    @GetMapping("/add-product") public String addProductPage(HttpSession session){Integer sellerId=(Integer)session.getAttribute("sellerId");if(sellerId==null)return "redirect:/login";return "add-product";}
    @PostMapping("/add-product") public String addProduct(@RequestParam("productName")String productName,@RequestParam("description")String description,@RequestParam("price")double price,@RequestParam("stock")int stock,@RequestParam("category")String category,HttpSession session,Model model){
        Integer sellerId=(Integer)session.getAttribute("sellerId");if(sellerId==null)return "redirect:/login";Product p=new Product();p.setSellerId(sellerId);p.setProductName(productName);p.setDescription(description);p.setPrice(price);p.setStock(stock);p.setCategory(category);boolean result=productService.addProduct(p);model.addAttribute("message",result?"Product added successfully!":"Failed to add product.");return "add-product";}
    @GetMapping("/my-products") public String myProducts(HttpSession session,Model model){Integer sellerId=(Integer)session.getAttribute("sellerId");if(sellerId==null)return "redirect:/login";List<Product> products=productService.getProductsBySeller(sellerId);model.addAttribute("products",products);return "my-products";}
    @GetMapping("/products") public String products(HttpSession session,Model model){Integer customerId=(Integer)session.getAttribute("customerId");if(customerId==null)return "redirect:/customer-login";model.addAttribute("products",productService.getAllProducts());return "products";}
}
