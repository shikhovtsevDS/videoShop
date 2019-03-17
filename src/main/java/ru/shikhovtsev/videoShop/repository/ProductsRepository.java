package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.videoShop.model.Product;

public interface ProductsRepository extends JpaRepository<Long, Product> {
}
