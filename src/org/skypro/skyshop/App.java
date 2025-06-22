package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basketFirst = new ProductBasket();
        ProductBasket basketSecond = new ProductBasket();

        basketFirst.addProductToBasket(new Product("Яблоки", 150));
        basketFirst.addProductToBasket(new Product("Бананы", 250));
        basketFirst.addProductToBasket(new Product("Апельсины", 220));
        basketFirst.addProductToBasket(new Product("Картошка", 400));
        basketFirst.addProductToBasket(new Product("Виноград", 480));

        basketFirst.addProductToBasket(new Product("Грейпфрут", 300));

        basketSecond.addProductToBasket(new Product("Автомобиль BMV X5", 12_000_000));
        basketSecond.addProductToBasket(new Product("Автомобиль Toyota land Cruiser", 10_500_000));

        basketSecond.printBasketDetails();

        System.out.println("Поиск товара, который есть в корзине = " + basketSecond.checkProductInBasketByName("Автомобиль BMV X5"));

        System.out.println("Поиск товара, которого нет в корзине = " + basketFirst.checkProductInBasketByName("Грейпфрут"));

        basketFirst.clearBasket();

        basketFirst.printBasketDetails();

        System.out.println("Поиск товара по имени в пустой корзине = " + basketFirst.checkProductInBasketByName("Картошка"));

    }
}