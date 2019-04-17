package ru.shikhovtsev.videoShop.web.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.DeliveryState;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.service.OrderService;
import ru.shikhovtsev.videoShop.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/ajax/profile/orders")
public class AjaxOrderController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public AjaxOrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Order get(@PathVariable("id") int id) {
        return orderService.get(id, AuthorizedUser.id());
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll(AuthorizedUser.id());
    }

    @PostMapping(value = "/bag")
    public void saveOrder(@Valid Order order) {
        order.setState(DeliveryState.IN_PROCESSING);
        List<Product> bag = productService.getBag(AuthorizedUser.id());
        orderService.saveOrder(bag, order);
        bag.forEach(p -> productService.deleteFromUsersProducts(p.getId(), AuthorizedUser.id()));
    }

    @DeleteMapping(value = "/bag/{id}")
    public void deleteFromUsersProducts(@PathVariable("id") int id) {
        productService.deleteFromUsersProducts(id, AuthorizedUser.id());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        int userId = AuthorizedUser.id();
        log.info("delete order {} for user {}", id, userId);
        orderService.delete(id, userId);
    }

    @PostMapping("/bag/{id}")
    public void addToBag(@PathVariable("id") int id) {
        productService.addToBag(id, AuthorizedUser.id());
    }
}
