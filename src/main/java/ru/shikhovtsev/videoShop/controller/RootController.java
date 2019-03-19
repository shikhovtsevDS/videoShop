package ru.shikhovtsev.videoShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shikhovtsev.videoShop.service.ProductsService;

@Controller
public class RootController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/products")
    public String meals(Model model) {
        model.addAttribute("meals", productsService.getAll());
        return "products";
    }
}
