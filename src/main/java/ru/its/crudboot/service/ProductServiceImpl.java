package ru.its.crudboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.its.crudboot.models.Product;
import ru.its.crudboot.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> All() {
        return productRepository.findAll();
    }

    @Override
    public Product add(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product change(String id, Product product) {
        productRepository.update(UUID.fromString(id),product);
        return product;
    }

    @Override
    public void removeById(String id) {
        productRepository.deleteById(UUID.fromString(id));
    }
}
