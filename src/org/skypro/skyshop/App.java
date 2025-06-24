package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basketFirst = new ProductBasket();
        ProductBasket basketSecond = new ProductBasket();
        ProductBasket basketThird = new ProductBasket();

        basketFirst.addProductToBasket(new SimpleProduct("Яблоки", 150));
        basketFirst.addProductToBasket(new SimpleProduct("Бананы", 250));
        basketFirst.addProductToBasket(new SimpleProduct("Апельсины", 300));
        basketFirst.addProductToBasket(new DiscountedProduct("Картошка", 500, 10));
        basketFirst.addProductToBasket(new FixPriceProduct("Пакет для продуктов"));

        basketFirst.addProductToBasket(new SimpleProduct("Грейпфрут", 300));

        basketSecond.addProductToBasket(new SimpleProduct("Автомобиль BMV X5", 12_000_000));
        basketSecond.addProductToBasket(new DiscountedProduct("Автомобиль Toyota land Cruiser", 10_500_000, 15));

        basketThird.addProductToBasket(new DiscountedProduct("Iphone 14 Pro", 60_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 15 Pro", 70_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 15 Pro Max", 80_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 16 Pro Max", 90_000, 10));
        basketThird.addProductToBasket(new FixPriceProduct("Сувенирный пакет с лейблом IPHONE"));
        
        basketFirst.printBasketDetails();
        basketSecond.printBasketDetails();
        basketThird.printBasketDetails();

        System.out.println("Поиск товара, который есть в корзине = " + basketSecond.checkProductInBasketByName("Автомобиль BMV X5"));

        System.out.println("Поиск товара, которого нет в корзине = " + basketFirst.checkProductInBasketByName("Грейпфрут"));

        basketFirst.clearBasket();

        basketFirst.printBasketDetails();

        System.out.println("Поиск товара по имени в пустой корзине = " + basketFirst.checkProductInBasketByName("Картошка"));

    }
}