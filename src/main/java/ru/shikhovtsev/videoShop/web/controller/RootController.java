package ru.shikhovtsev.videoShop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.shikhovtsev.videoShop.AuthorizedUser;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.to.UserTo;

@Controller
public class RootController extends AbstractUserController {

    @GetMapping("/")
    public String index() {
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
            return "redirect:meals";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "registration";
    }

    @PostMapping("/register")
    public String saveRegister(User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "registration";
        } else {
            super.create(user);
            status.setComplete();
            return "redirect:login?email=" + user.getEmail();
        }
    }
}
