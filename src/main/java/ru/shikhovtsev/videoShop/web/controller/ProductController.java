package ru.shikhovtsev.videoShop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.service.CategoryService;
import ru.shikhovtsev.videoShop.service.ProductsService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductsService productsService;
    private final CategoryService categoryService;

    public ProductController(ProductsService productsService, CategoryService categoryService) {
        this.productsService = productsService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/", ""})
    public String getAll(Model model) {
        model.addAttribute("products", productsService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "products";
    }

    @GetMapping({"/category/{name}"})
    public String getAll(@PathVariable("name") String category, Model model) {
        model.addAttribute("products", productsService.getAllByCategories(categoryService.getByName(category)));
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
