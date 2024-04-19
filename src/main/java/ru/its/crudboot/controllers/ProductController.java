package ru.its.crudboot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.its.crudboot.models.Product;
import ru.its.crudboot.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.All());
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(product));
    }

    @PutMapping("/product/{product-id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("product-id") String id, @RequestBody Product product) {
        return ResponseEntity.accepted().body(productService.change(id, product));
    }

    @DeleteMapping("/product/{product-id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("product-id") String id) {
        productService.removeById(id);
        return ResponseEntity.accepted().build();
    }
}
