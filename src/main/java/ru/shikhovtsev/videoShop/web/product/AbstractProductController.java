package ru.shikhovtsev.videoShop.web.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.service.CategoryService;
import ru.shikhovtsev.videoShop.service.ProductService;

import java.util.List;

public abstract class AbstractProductController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    public List<Product> getAll() {
        log.info("getAll");
        return productService.getAll();
    }

    public Product get(int id) {
        log.info("get {}", id);
        return productService.get(id);
    }

    public Product create(Product Product) {
        log.info("create {}", Product);
        return null/*productService.create(Product)*/;
    }

    public void delete(int id) {
        log.info("delete {}", id);
        productService.delete(id);
    }

    public void update(Product product) {
        log.info("update {} with id={}", product, product.getId());
        productService.update(product);
    }
}
