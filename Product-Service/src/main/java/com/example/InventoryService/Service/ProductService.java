package com.example.InventoryService.Service;

import com.example.InventoryService.Model.Product;
import com.example.InventoryService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public Product save(Product product) {
        Product existingProduct=productRepository.findByName(product.getName());

        if (existingProduct==null) {
            return productRepository.save(product);
        }
        else {

            existingProduct.setQuantity(existingProduct.getQuantity()+product.getQuantity());

            return productRepository.save(existingProduct);

        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {

        return productRepository.findById(id);
    }
}
