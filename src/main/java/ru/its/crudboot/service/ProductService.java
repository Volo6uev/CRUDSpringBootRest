package ru.its.crudboot.service;

import ru.its.crudboot.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> All();
    Product add(Product product);
    Product change(String id, Product product);
    void removeById(String id);
}
