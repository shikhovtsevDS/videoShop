package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.shikhovtsev.videoShop.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM public.orders WHERE user_id = ?1",
        nativeQuery = true)
    List<Order> findAllByUserId(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Order o WHERE o.id=?1")
    int delete(int id);

    @Query(value = "SELECT product_count FROM orders_products WHERE order_id = ?1 AND product_id = ?2", nativeQuery = true)
    int getCount(int idOrder, int idProduct);

    @Transactional
    @Modifying
    @Query("DELETE FROM Order o WHERE o.id=:id AND o.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);


    @Query(value = "UPDATE orders_products SET product_count=?2 WHERE order_id=?1", nativeQuery = true)
    int updateCount(int id, int count);

    @Query(value = "SELECT * FROM public.orders WHERE user_id = ?1 AND confirmed=false", nativeQuery = true)
    Order getBag(int userId);
}
