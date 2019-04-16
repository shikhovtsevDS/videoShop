package ru.shikhovtsev.videoShop.web.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class AjaxProductController extends AbstractProductController {

    @GetMapping(value = "/{id}")
    public String get(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("product", super.get(id));
        return "product";
    }
}
