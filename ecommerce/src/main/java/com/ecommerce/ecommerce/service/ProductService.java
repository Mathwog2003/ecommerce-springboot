package com.ecommerce.ecommerce.service;

// ProductService.java
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.repositary.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        if (productRepository.existsById(productId)) {
            updatedProduct.setId(productId);
            return productRepository.save(updatedProduct);
        }
        return null; // Product with given ID not found
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

