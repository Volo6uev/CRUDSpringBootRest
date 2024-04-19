package ru.its.crudboot.repository;

import ru.its.crudboot.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    List<Product> findAll();
    void save(Product product);
    void update(UUID id, Product product);
    void deleteById(UUID id);
}
