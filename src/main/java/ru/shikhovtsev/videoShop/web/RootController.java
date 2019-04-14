package ru.shikhovtsev.videoShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.service.ProductsService;
import ru.shikhovtsev.videoShop.to.UserTo;
import ru.shikhovtsev.videoShop.web.user.AbstractUserController;

@Controller
public class RootController extends AbstractUserController {

    private final ProductsService productsService;

    public RootController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productsService.getAll());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
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

    @PostMapping("/profile")
    public String updateProfile(UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            super.update(userTo, AuthorizedUser.id());
            AuthorizedUser.get().update(userTo);
            status.setComplete();
            return "redirect:/";
        }
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
