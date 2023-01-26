package com.example.InventoryService.Controller;

import com.example.InventoryService.Model.Product;
import com.example.InventoryService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-service")
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


    @PostMapping("/checkProduct/{id}")
    public Optional<Product> productCheck(@PathVariable("id") Integer id){

        return productService.findById(id);

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product>products=productService.getAllProducts();

        return new ResponseEntity<>(products,HttpStatus.OK);


    }
}
