package ru.shikhovtsev.videoShop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shikhovtsev.videoShop.model.Order;

import java.util.List;

@Repository
public class OrderRepositoryExtended {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderRepositoryExtended(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Order save(Order order, int userId) {
        if (!order.isNew() && get(order.getId(), userId) == null) {
            return null;
        }
        order.setUser(userRepository.getOne(userId));
        return orderRepository.save(order);
    }

    @Transactional
    public Order update(Order order) {
        if (!order.isNew() && get(order.getId()) == null) {
            return null;
        }
        Order oldOrder = orderRepository.getOne(order.getId());
        order.setUser(userRepository.getOne(oldOrder.getUser().getId()));
        return orderRepository.save(order);
    }

    public boolean delete(int id) {
        return orderRepository.delete(id) != 0;
    }

    public boolean delete(int id, int userId) {
        return orderRepository.delete(id, userId) != 0;
    }

    public Order get(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order get(int id, int userId) {
        return orderRepository.findById(id).filter(order -> order.getUser().getId() == userId).orElse(null);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Order> getAll(int userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public boolean updateCount(int id, int count, int userId) {
        return get(id, userId) != null && orderRepository.updateCount(id, count) != 0;
    }

    public Order getBag(int userId) {
        return orderRepository.getBag(userId);
    }

    public void insertIntoOrdersProducts(int orderId, int productId) {
        orderRepository.insertIntoOrdersProducts(orderId, productId);
    }
}
