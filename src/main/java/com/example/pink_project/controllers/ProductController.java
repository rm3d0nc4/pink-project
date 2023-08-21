package com.example.pink_project.controllers;

import com.example.pink_project.dtos.ProductDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String fetchAllProducts(Model model) {
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/products/create")
    public String createProductPage(Model model) {
        ProductDto product = new ProductDto();
        model.addAttribute("product", product);
        return "create-product";
    }
    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute("product") ProductDto product) {
        // Leitura e conversão só é feita caso existam os setters do model. Caso contrário,
        // os dados serão retornados como nulos;

        System.out.println(product);
        productService.createProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam UUID id) {
        System.out.println(id);
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @PostMapping("/products/change-status")
    public String changeProductStatus(@RequestParam UUID id) {
        System.out.println(id);
        productService.changeStatus(id);
        return "redirect:/products";
    }
}
