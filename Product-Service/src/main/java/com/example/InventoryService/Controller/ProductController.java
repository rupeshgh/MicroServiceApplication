package com.example.InventoryService.Controller;

import com.example.InventoryService.Model.Product;
import com.example.InventoryService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {


        Product prod = productService.save(product);

        if (prod == null) {

            return (ResponseEntity<?>) ResponseEntity.badRequest();
        } else return new ResponseEntity<>(prod, HttpStatus.OK);
    }
}