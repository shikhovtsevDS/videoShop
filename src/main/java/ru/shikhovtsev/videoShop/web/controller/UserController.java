package ru.shikhovtsev.videoShop.web.controller;

import org.springframework.stereotype.Controller;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void create(User user) {
        userService.create(user);
    }


}
