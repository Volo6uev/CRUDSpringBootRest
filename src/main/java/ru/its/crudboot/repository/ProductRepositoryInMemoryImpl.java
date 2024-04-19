package ru.its.crudboot.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.its.crudboot.models.Product;

import java.util.List;
import java.util.UUID;

@Profile("default")
@Repository
@RequiredArgsConstructor
public class ProductRepositoryInMemoryImpl implements ProductRepository{

    private final List<Product> products;

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(UUID id, Product product) {
        int index = -1;
        for(int i = 0;i < products.size();i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            String name = product.getName();
            Integer cost = product.getCost();
            Integer amount = product.getAmount();
            products.remove(index);
            Product newProduct = new Product(id,name,cost,amount);
            products.add(newProduct);
        }
    }

    @Override
    public void deleteById(UUID id) {
        int index = -1;
        for(int i = 0;i < products.size();i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.remove(index);
        }
    }
}
