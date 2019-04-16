package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.repository.OrderRepositoryExtended;

import java.util.List;

import static ru.shikhovtsev.videoShop.util.ValidationUtil.checkNotFoundWithId;

@Service
public class OrderService {

    @Autowired
    private final OrderRepositoryExtended repository;

    public OrderService(OrderRepositoryExtended repository) {
        this.repository = repository;
    }

    public Order get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Order get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public Order getBag(int userId) {
        Order bag = repository.getBag(userId);
        if (bag == null) {
            Order newBag = new Order();
            repository.save(newBag, userId);
            return newBag;
        }
        return bag;
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public List<Order> getAll() {
        return repository.getAll();
    }

    public List<Order> getAll(int userId) {
        return repository.getAll(userId);
    }

    public Order update(Order order) {
        return checkNotFoundWithId(repository.update(order), order.getId());
    }

    public Order update(Order order, int userId) {
        return checkNotFoundWithId(repository.save(order, userId), order.getId());
    }

    public Order create(Order order, int userId) {
        Assert.notNull(order, "Order must not be null");
        return repository.save(order, userId);
    }

    public void updateCount(int id, int count, int userId) {
        repository.updateCount(id, count, userId);
    }
}
