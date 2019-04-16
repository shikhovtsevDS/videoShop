package ru.shikhovtsev.videoShop.web.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/ajax/orders")
public class AdminAjaxOrderController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final OrderService orderService;

    @Autowired
    public AdminAjaxOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public Order get(@PathVariable("id") int id) {
        log.info("get order {} for admin", id);
        return orderService.get(id);
    }

    @GetMapping
    public List<Order> getAll() {
        log.info("getAll for admin");
        return orderService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        log.info("delete order {} for admin", id);
        orderService.delete(id);
    }

    @PostMapping
    public void update(@Valid Order order) {
        log.info("update {} for admin", order);
        orderService.update(order);
    }
}
