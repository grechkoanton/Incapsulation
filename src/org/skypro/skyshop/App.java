package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basketZero = new ProductBasket();
        ProductBasket basketFirst = new ProductBasket();
        ProductBasket basketSecond = new ProductBasket();
        ProductBasket basketThird = new ProductBasket();

        try {
            SimpleProduct simpleProduct = new SimpleProduct("", 20_000);
            basketZero.addProductToBasket(simpleProduct);
        } catch (IllegalArgumentException exc) {
            System.out.println("Некорректные данные у продуктов! " + exc.getMessage());
        } finally {
            System.out.println("Проверка прошла - (либо с ошибкой, либо без нее).");
        }

        try {
            basketZero.addProductToBasket(new DiscountedProduct("Товары для рыбалки", -10000, 10));
        } catch (IllegalArgumentException exc) {
            System.out.println("Некорректные данные у продуктов! " + exc.getMessage());
        } finally {
            System.out.println("Проверка прошла - (либо с ошибкой, либо без нее).");
        }

        try {
            DiscountedProduct snowboard = new DiscountedProduct("Сноуборд", 55_000, 120);
            basketZero.addProductToBasket(snowboard);
        } catch (IllegalArgumentException exc) {
            System.out.println("Некорректные данные у товара! " + exc.getMessage());
        } finally {
            System.out.println("Проверка прошла - (либо с ошибкой, либо без нее).");
        }

        basketZero.printBasketDetails();

        SearchEngine searchEngine1 = new SearchEngine(7);
        SimpleProduct mountainsSki = new SimpleProduct("Горные лыжи", 100_000);
        searchEngine1.add(mountainsSki);
        try {
            System.out.println(searchEngine1.findBestFoundMatch("Гор"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine1.findBestFoundMatch("Снег"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        SimpleProduct apple = new SimpleProduct("Яблоки", 150);
        basketFirst.addProductToBasket(apple);
        basketFirst.addProductToBasket(new SimpleProduct("Апельсины", 300));
        SimpleProduct bananas = new SimpleProduct("Бананы", 250);
        basketFirst.addProductToBasket(bananas);
        DiscountedProduct potato = new DiscountedProduct("Картошка", 500, 10);
        basketFirst.addProductToBasket(potato);
        basketFirst.addProductToBasket(new FixPriceProduct("Пакет для продуктов"));

        basketFirst.addProductToBasket(new SimpleProduct("Грейпфрут", 300));

        SimpleProduct bmvX5 = new SimpleProduct("Автомобиль BMV X5", 12_000_000);
        basketSecond.addProductToBasket(bmvX5);
        DiscountedProduct toyotaLandCruiser = new DiscountedProduct("Автомобиль Toyota land Cruiser", 10_500_000, 15);
        basketSecond.addProductToBasket(toyotaLandCruiser);

        basketThird.addProductToBasket(new DiscountedProduct("Iphone 14 Pro", 60_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 15 Pro", 70_000, 10));
        basketThird.addProductToBasket(new DiscountedProduct("Iphone 15 Pro Max", 80_000, 10));
        DiscountedProduct iphone16ProMax = new DiscountedProduct("Iphone 16 Pro Max", 90_000, 10);
        basketThird.addProductToBasket(iphone16ProMax);
        basketThird.addProductToBasket(new FixPriceProduct("Сувенирный пакет с лейблом IPHONE"));

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(potato);
        searchEngine.add(bananas);
        searchEngine.add(bmvX5);
        searchEngine.add(toyotaLandCruiser);
        searchEngine.add(iphone16ProMax);


        Article article0 = new Article("Картошка из лукошка", "Из деревни с любовью");
        Article article1 = new Article("Бананы из Африки", "Лучшие бананы в мире");
        Article article2 = new Article("Немецкий автомобиль", "БМВ лучший в своем сегменте");
        Article article3 = new Article("Японский автомобиль", "Тойота один из лучших на востоке и не только");
        Article article4 = new Article("Iphone Pro Max смартфон", "Iphone Pro Max топовая линейка в компании Apple");
        searchEngine.add(article0);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);


        System.out.println(Arrays.toString(searchEngine.search("Картошка")));
        System.out.println(Arrays.toString(searchEngine.search("Бананы")));
        System.out.println(Arrays.toString(searchEngine.search("БМВ")));
        System.out.println(Arrays.toString(searchEngine.search("Тойота")));
        System.out.println(Arrays.toString(searchEngine.search("Iphone")));

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