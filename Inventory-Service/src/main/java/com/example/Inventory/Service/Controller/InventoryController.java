package com.example.Inventory.Service.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Inventory.Service.Entity.Product;

import com.example.Inventory.Service.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class InventoryController {

    private final ProductRepository repo;

    public InventoryController(ProductRepository repo) {
        this.repo = repo;
    }
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }
}
