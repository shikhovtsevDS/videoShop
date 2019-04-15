package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.Category;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void create(Product product) {
        productsRepository.save(product);
    }

    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }

    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    public List<Product> getAllByCategories(Category category) {
        return productsRepository.findAllByCategories(category);
    }

    public Product get(Integer id) {
        return productsRepository.findById(id).orElse(null);
    }

    public void update(Product product) {
        productsRepository.save(product);
    }
}
