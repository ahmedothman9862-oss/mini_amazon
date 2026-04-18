package com.example.MiniAmazon.Repo;

import com.example.MiniAmazon.Dto.ProductDTO;
import com.example.MiniAmazon.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
