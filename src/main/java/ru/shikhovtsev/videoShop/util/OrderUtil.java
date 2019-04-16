package ru.shikhovtsev.videoShop.util;

import ru.shikhovtsev.videoShop.model.Product;

import java.util.List;

public class OrderUtil {

    public static int totalCost(List<Product> order) {
        return order.stream().mapToInt(Product::getCost).sum();
    }

}
