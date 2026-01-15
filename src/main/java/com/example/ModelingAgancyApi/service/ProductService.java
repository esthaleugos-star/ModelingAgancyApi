package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id); // Changed to Optional for safety
    Product updateProduct(Long id, Product productDetails); // 🆕 New
    void deleteProduct(Long id); // 🆕 New
}