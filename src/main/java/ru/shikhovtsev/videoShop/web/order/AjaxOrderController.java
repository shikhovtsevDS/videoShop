package ru.shikhovtsev.videoShop.web.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/ajax/profile/orders")
public class AjaxOrderController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final OrderService orderService;

    @Autowired
    public AjaxOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public Order get(@PathVariable("id") int id) {
        return orderService.get(id, AuthorizedUser.id());
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll(AuthorizedUser.id());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        int userId = AuthorizedUser.id();
        log.info("delete order {} for user {}", id, userId);
        orderService.delete(id, userId);
    }

    @PostMapping
    public void update(@Valid Order order) {
        int userId = AuthorizedUser.id();
        log.info("update {} for user {}", order, userId);
        orderService.update(order, userId);
    }

    @PostMapping(value = "/{id}")
    public void updateCount(@PathVariable("id") int id, @RequestParam("productId") int productId, @RequestParam("count") int count) {
        int userId = AuthorizedUser.id();
        log.info("update count {} for order {}, product {}, user {}", count, id, productId, userId);
        orderService.updateCount(id, count, userId);
    }
}
