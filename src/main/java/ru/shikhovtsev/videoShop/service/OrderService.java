package ru.shikhovtsev.videoShop.service;

import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.repository.OrderRepository;
import ru.shikhovtsev.videoShop.repository.UserRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository repository, UserRepository userRepository) {
        this.orderRepository = repository;
        this.userRepository = userRepository;
    }

    public Order save(Order Order, int userId) {
        if (!Order.isNew() && get(Order.getId(), userId) == null) {
            return null;
        }
        Order.setUser(userRepository.getOne(userId));
        return orderRepository.save(Order);
    }

    public boolean delete(int id, int userId) {
//        return orderRepository.delete(id, userId) != 0;
        return true;
    }

    public boolean delete(int id) {
        return orderRepository.delete(id) != 0;
    }

    public Order get(int id, int userId) {
        return orderRepository.findById(id).filter(Order -> Order.getUser().getId() == userId).orElse(null);
    }

    public Order get(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAll(int userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
