package ru.shikhovtsev.videoShop.util;

import ru.shikhovtsev.videoShop.model.Order;
import ru.shikhovtsev.videoShop.model.Product;

public class OrderUtil {

    public static int totalCost(Order order) {
        return order.getProducts().stream().mapToInt(Product::getCost).sum();
    }

}
