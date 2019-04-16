package ru.shikhovtsev.videoShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.service.CategoryService;
import ru.shikhovtsev.videoShop.service.OrderService;
import ru.shikhovtsev.videoShop.service.ProductService;
import ru.shikhovtsev.videoShop.to.UserTo;
import ru.shikhovtsev.videoShop.util.OrderUtil;
import ru.shikhovtsev.videoShop.util.UserUtil;
import ru.shikhovtsev.videoShop.web.user.AbstractUserController;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RootController extends AbstractUserController {

    private final ProductService productService;
    private final OrderService orderService;
    private final CategoryService categoryService;

    public RootController(ProductService productService, OrderService orderService, CategoryService categoryService) {
        this.productService = productService;
        this.orderService = orderService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "index";
    }

    @GetMapping("/bag")
    public String bag(ModelMap model) {
        List<Product> bag = productService.getBag(AuthorizedUser.id());
        model.addAttribute("products", bag);
        model.addAttribute("totalCost", OrderUtil.totalCost(bag));
        return "order";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/orders")
    public String orders() {
        return "orders";
    }

    @GetMapping("/orders/{id}")
    public String order(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("order", orderService.get(id, AuthorizedUser.id()));
        return "order";
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }


    @RestController
    public static class AjaxRootController extends AbstractUserController {
        @PostMapping("/profile")
        public void updateProfile(@Valid UserTo userTo) {
            super.update(userTo, AuthorizedUser.id());
            AuthorizedUser.get().update(userTo);
        }

        @PostMapping("/register")
        public String saveRegister(@Valid UserTo userTo) {
            super.create(UserUtil.createNewFromTo(userTo, "qwerty123"));
            return "redirect:login?email=" + userTo.getEmail();
        }
    }

    @PostMapping(value = "/order/{id}")
    public void deleteFromUsersProducts(@PathVariable("id") int id) {
        productService.deleteFromUsersProducts(AuthorizedUser.get().getUserTo().getId(), id);
    }

    public void saveOrder(@Valid Order order) {
        orderService.saveOrder(productService.getBag(AuthorizedUser.id()), order);
    }
}
