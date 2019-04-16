package ru.shikhovtsev.videoShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.service.OrderService;
import ru.shikhovtsev.videoShop.service.ProductService;
import ru.shikhovtsev.videoShop.to.UserTo;
import ru.shikhovtsev.videoShop.web.user.AbstractUserController;

import javax.validation.Valid;

@Controller
public class RootController extends AbstractUserController {

    private final ProductService productService;
    private final OrderService orderService;

    public RootController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "index";
    }

    @GetMapping("/bag")
    public String bag(ModelMap model) {
        model.addAttribute("order", orderService.getBag(AuthorizedUser.id()));
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

    @PostMapping("/profile")
    public void updateProfile(@Valid UserTo userTo) {
        super.update(userTo, AuthorizedUser.id());
        AuthorizedUser.get().update(userTo);
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(User user, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        } else {
            super.create(user);
            status.setComplete();
            return "redirect:login?email=" + user.getEmail();
        }
    }
}
