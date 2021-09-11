package ru.job4j.pojo;

/**
 * 1.2.3.Инкапсуляция
 * 3.2.Удаление моделей из массива.[#310016]
 *
 * @since 11.10.2021
 */
public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
            if (i + 1 < products.length && products[i + 1] != null) {
                products[i] = products[i + 1];
            } else {
                products[i] = null;
                break;
            }
        }
        return products;
    }
}
