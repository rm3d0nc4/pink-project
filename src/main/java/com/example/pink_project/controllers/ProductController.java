package com.example.pink_project.controllers;

import com.example.pink_project.dtos.ProductDto;
import com.example.pink_project.entities.Product;
import com.example.pink_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ProductController {

    @Autowired
    private  ProductRepository repository;

    private final AtomicLong idGenerator = new AtomicLong();
    @GetMapping("/products")
    public String fetchAllProducts(Model model) {
        List<Product> products = repository.fetchAllProducts();
        System.out.println(model.getAttribute("product"));
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/products/create-product")
    public String createProductPage(Model model) {
        model.addAttribute("product", new ProductDto());
        return "create-product";
    }
    @PostMapping("/products/create-product")
    public String createProduct(@ModelAttribute ProductDto dto, Model model) {
//        model.getAttribute("product");
        model.addAttribute("product", dto);
        System.out.println(dto.toString());

        Product product = new Product(
                idGenerator.incrementAndGet(),
                dto.getName(),
                dto.isAvailable(),
                dto.getDestination(),
                dto.getReturnRate(),
                dto.getTerm(),
                dto.getAdministrationRate()
        );
        repository.createProduct(product);
        return "redirect:/products";
    }
}
