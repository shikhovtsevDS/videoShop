package ru.shikhovtsev.videoShop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.shikhovtsev.videoShop.model.User;

@Controller
public class RootController {

    @Autowired
    private final UserController userController;

    public RootController(UserController userController) {
        this.userController = userController;
    }

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

    @GetMapping("/registration")
    public String registration() {
        return "registration";
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
            userController.create(user);
            status.setComplete();
            return "redirect:login?email=" + user.getEmail();
        }
    }
}
