package ru.shikhovtsev.videoShop.web.product;

import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.videoShop.model.Product;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ajax/admin/products")
public class AdminAjaxProductController extends AbstractProductController {

    @Override
    @GetMapping
    public List<Product> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Product get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@Valid Product product) {
        if (product.isNew()) {
            super.create(product);
        } else {
            super.update(product);
        }
    }
}
