package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersForUser(Integer id) {
        return orderRepository.findAllByUserId(id);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
