package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basketFirst = new ProductBasket();
        ProductBasket basketSecond = new ProductBasket();
        ProductBasket basketThird = new ProductBasket();

        SimpleProduct apple = new SimpleProduct("Яблоки", 150);
        basketFirst.addProductToBasket(apple);
        SimpleProduct bananas = new SimpleProduct("Бананы", 250);
        basketFirst.addProductToBasket(bananas);
        basketFirst.addProductToBasket(new SimpleProduct("Апельсины", 300));
        DiscountedProduct potato = new DiscountedProduct("Картошка", 500, 10);
        basketFirst.addProductToBasket(potato);
        basketFirst.addProductToBasket(new FixPriceProduct("Пакет для продуктов"));

        basketFirst.addProductToBasket(new SimpleProduct("Грейпфрут", 300));

        SimpleProduct bmvX5 = new SimpleProduct("Автомобиль BMV X5", 12_000_000);
        basketSecond.addProductToBasket(bmvX5);
        basketSecond.addProductToBasket(new DiscountedProduct("Автомобиль Toyota land Cruiser", 10_500_000, 15));

        basketThird.addProductToBasket(new DiscountedProduct("Iphone 14 Pro", 60_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 15 Pro", 70_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 15 Pro Max", 80_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 16 Pro Max", 90_000, 10));
        basketThird.addProductToBasket(new FixPriceProduct("Сувенирный пакет с лейблом IPHONE"));

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(potato);
        searchEngine.add(bananas);
        searchEngine.add(bmvX5);


        Article article0 = new Article("Картошка из лукошка", "Из деревни с любовью");
        Article article1 = new Article("Бананы из Африки", "Лучшие бананы в мире");
        Article article2 = new Article("Немецкий автомобиль", "БМВ лучший в своем сегменте");
        searchEngine.add(article0);
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println(Arrays.toString(searchEngine.search("Картошка")));
        System.out.println(Arrays.toString(searchEngine.search("Бананы")));
        System.out.println(Arrays.toString(searchEngine.search("БМВ")));

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