package com.example.Inventory.Service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Service.Entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
