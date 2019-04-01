package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.videoShop.model.Category;
import ru.shikhovtsev.videoShop.model.Product;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCost(Double cost);

    List<Product> findAllByCategories(Category category);
}
