package ru.shikhovtsev.videoShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shikhovtsev.videoShop.service.ProductsService;

@Controller
public class RootController {

    private final ProductsService productsService;

    @Autowired
    public RootController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String index(Model model) {
        String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/products")
    public String meals(Model model) {
        model.addAttribute("products", productsService.getAll());
        return "products";
    }
}
