package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import java.util.Objects;


public abstract class Product implements Searchable {
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
    public String searchTerm() {
        return name;
    }

    @Override
    public String getSearchTypContent() {
        return "PRODUCT";
    }

    @Override
    public String getNameSearchable() {
        return name;
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

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
