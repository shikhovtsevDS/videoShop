package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public void createProduct(Product product) {
        productsRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productsRepository.delete(product);
    }

    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }
}
