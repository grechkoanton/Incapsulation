package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара отсутствует!");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость товара отрицательная!");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Название товара: " + name + ". Стоимость: " + price + " руб.";
    }
}
