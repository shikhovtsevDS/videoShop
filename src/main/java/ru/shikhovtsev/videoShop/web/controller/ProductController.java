package ru.shikhovtsev.videoShop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.service.CategoryService;
import ru.shikhovtsev.videoShop.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/", ""})
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "products";
    }

    @GetMapping({"/category/{name}"})
    public String getAll(@PathVariable("name") String category, Model model) {
        model.addAttribute("products", productService.getAllByCategories(categoryService.getByName(category)));
        return "products";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "product";
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        productService.delete(id);
    }

    @PostMapping
    public void createOrUpdate(Product product) {
        if (product.isNew()) {
            productService.create(product);
        } else {
            productService.update(product);
        }
    }
}
