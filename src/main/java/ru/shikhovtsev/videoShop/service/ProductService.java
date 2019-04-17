package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.Category;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getAllByCategories(Category category) {
        return productRepository.findAllByCategories(category);
    }

    public Product get(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void update(Product product) {
        productRepository.save(product);
    }


    public List<Product> getBag(int userId) {
        return productRepository.getAllByUserId(userId);
    }

    public void deleteFromUsersProducts(int productId, int userId) {
        productRepository.deleteFromUsersProducts(productId, userId);
    }

    public void addToBag(int productId, int userId) {
        productRepository.addToBag(productId, userId);
    }
}
