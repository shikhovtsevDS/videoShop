package ru.shikhovtsev.videoShop.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Long, Products> {
}
