package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.videoShop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
