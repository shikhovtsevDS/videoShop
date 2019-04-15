package ru.shikhovtsev.videoShop.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/ajax/orders")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        return orderService.getAll(userId);
    }

    @GetMapping(value = "/{id}")
    public Order get(@PathVariable("id") int id) {
        int userId = AuthorizedUser.id();
        log.info("get meal {} for user {}", id, userId);
        return orderService.get(id, userId);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        int userId = AuthorizedUser.id();
        log.info("delete meal {} for user {}", id, userId);
        orderService.delete(id, userId);
    }

    @PostMapping(value = "/{id}")
    public void count(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        System.out.println("test");
    }
}
