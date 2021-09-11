package ru.job4j.pojo;

/**
 * 1.2.3.Инкапсуляция
 * 3.1.Массив с пустыми ячейками[#176470#127072]
 *
 * @since 11.10.2021
 */
public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ":"
                        + product.getCount());
            }
        }
    }

    public static int indexOfNull(Product[] products) {
        int rsl = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
