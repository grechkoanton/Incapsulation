package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discount;

    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        if (basicPrice < 0) {
            throw new IllegalArgumentException("Стоимость товара отрицательная!");
        }
        this.basicPrice = basicPrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        if (basicPrice < 0) {
            throw new IllegalArgumentException("Стоимость товара отрицательная!");
        }
        return (int) basicPrice - (basicPrice * discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basicPrice == that.basicPrice && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basicPrice, discount);
    }

    @Override
    public String toString() {
        return "Название товара со скидкой: " + name + ". Стоимость: " + basicPrice + " руб." + " (" + discount + " %).";
    }

    @Override
    public String searchTerm() {
        return super.searchTerm();
    }

    @Override
    public String getSearchTypContent() {
        return super.getSearchTypContent();
    }

    @Override
    public String getNameSearchable() {
        return super.getNameSearchable();
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
