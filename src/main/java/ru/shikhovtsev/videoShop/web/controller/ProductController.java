package ru.shikhovtsev.videoShop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.service.ProductsService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping({"/", ""})
    public String products(Model model) {
        model.addAttribute("products", productsService.getAll());
        return "products";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productsService.get(id));
        return "product";
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        productsService.delete(id);
    }

    @PostMapping
    public void createOrUpdate(Product product) {
        if (product.isNew()) {
            productsService.create(product);
        } else {
            productsService.update(product);
        }
    }
}
