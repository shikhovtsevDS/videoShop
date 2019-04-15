package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.shikhovtsev.videoShop.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM public.orders WHERE user_id = ?1",
        nativeQuery = true)
    List<Order> findAllByUserId(int id);

    @Query("DELETE FROM Order o WHERE o.id=?1")
    int delete(int id);

}
