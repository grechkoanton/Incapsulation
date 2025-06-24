package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    protected String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара отсутствует!");
        }
        this.name = name;
    }

    public String getName() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара отсутствует!");
        }
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
