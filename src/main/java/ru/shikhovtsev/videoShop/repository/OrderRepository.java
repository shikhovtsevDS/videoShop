package ru.shikhovtsev.videoShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.videoShop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
