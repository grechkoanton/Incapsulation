package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    public Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProductToBasket(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт!");
    }
    public int calculateTotalBasketCost() {
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                sum += products[i].getPrice();
            }
        }
        return sum;
    }

    public void printBasketDetails() {
        int sum = 0;
        int specialCount = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
                sum += products[i].getPrice();
            }
            if (products[i] == null) {
                System.out.println("Ячейка в корзине пустая.");
            }
            if (products[i] != null && products[i].isSpecial()) {
                specialCount++;
            }

        }
        System.out.println("Итого: " + sum + " руб.");
        System.out.println("Специальных товаров: " + specialCount + " шт.");
    }

    public boolean checkProductInBasketByName(String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}