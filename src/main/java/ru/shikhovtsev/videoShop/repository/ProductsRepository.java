package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.shikhovtsev.videoShop.model.Category;
import ru.shikhovtsev.videoShop.model.Product;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCost(Double cost);

    List<Product> findAllByCategories(Category category);

    void deleteById(Integer id);

    @Query(value = "SELECT * FROM public.products WHERE id in (SELECT product_id FROM users_products WHERE user_id = ?1)",
            nativeQuery = true)
    List<Product> getAllByUserId(int userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.users_products WHERE user_id = ?1 and product_id = ?2",
            nativeQuery = true)
    void deleteFromUsersProducts(int userId, int productId);
}
