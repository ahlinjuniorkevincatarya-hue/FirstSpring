package com.example.first.controllers;

import com.example.first.model.Products;
import com.example.first.model.User;
import com.example.first.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductsController {

    private final ProductRepository productRepository ;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> findAll() {
         List<Products> products = productRepository.findAll();
         return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id) {

        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public ResponseEntity<Products> create(@RequestBody Products product) {
        Products newProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Products> update(@PathVariable Long id, @RequestBody Products products) {
        Products product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        products.setId(id);
        productRepository.save(products);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!productRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
