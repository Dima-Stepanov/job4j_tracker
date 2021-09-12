package ru.job4j.pojo;

/**
 * 1.2.3.Инкапсуляция
 * 3.2.Удаление моделей из массива.[#310016]
 *
 * @version 2
 * @since 11.10.2021
 */
public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
