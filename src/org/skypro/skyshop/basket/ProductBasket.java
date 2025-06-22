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
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
            if (products[i] == null) {
                System.out.println("Ячейка в корзине пустая.");
            }
        }
        System.out.println("Итого " + calculateTotalBasketCost() + " руб.");
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