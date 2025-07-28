package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

        SearchEngine searchEngine1 = new SearchEngine();
        SimpleProduct mountainsSki = new SimpleProduct("Горные лыжи", 100_000);
        searchEngine1.addSearchable(mountainsSki);
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

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addSearchable(potato);
        searchEngine.addSearchable(potato);
        searchEngine.addSearchable(bananas);
        searchEngine.addSearchable(bananas);
        searchEngine.addSearchable(bmvX5);
        searchEngine.addSearchable(toyotaLandCruiser);
        searchEngine.addSearchable(iphone16ProMax);

        Article article0 = new Article("Картошка из лукошка", "Картошка из деревни с любовью");
        Article article1 = new Article("Бананы из Африки", "Лучшие бананы в мире");
        Article article2 = new Article("Немецкий автомобиль", "БМВ лучший в своем сегменте");
        Article article3 = new Article("Японский автомобиль", "Тойота один из лучших на востоке и не только");
        Article article4 = new Article("Iphone Pro Max смартфон", "Iphone Pro Max топовая линейка в компании Apple");
        searchEngine.addSearchable(article0);
        searchEngine.addSearchable(article1);
        searchEngine.addSearchable(article2);
        searchEngine.addSearchable(article3);
        searchEngine.addSearchable(article4);

        Set<Searchable> searchResults1 = searchEngine.search("Кар");
        System.out.println(searchResults1);
        for (Searchable entry : searchResults1) {
            System.out.println("Наименование: " + entry.getNameSearchable());
        }
        Set<Searchable> searchResults2 = searchEngine.search("Бан");
        System.out.println(searchResults2);
        Set<Searchable> searchResults3 = searchEngine.search("БМ");
        System.out.println(searchResults3);
        Set<Searchable> searchResults4 = searchEngine.search("Той");
        System.out.println(searchResults4);
        Set<Searchable> searchResults5 = searchEngine.search("Iph");
        System.out.println(searchResults5);



        basketFirst.printBasketDetails();
        basketFirst.calculateTotalBasketCost();

        basketSecond.printBasketDetails();
        basketSecond.calculateTotalBasketCost();

        basketThird.printBasketDetails();
        basketThird.calculateTotalBasketCost();

        System.out.println("Поиск товара, который есть в корзине = " + basketFirst.checkProductInBasketByName("Грейпфрут"));

        System.out.println("Поиск товара, который есть в корзине = " + basketSecond.checkProductInBasketByName("Автомобиль BMV X5"));

        System.out.println("Поиск товара, которого нет в корзине = " + basketThird.checkProductInBasketByName("Собака"));

        List<Product> removedBmv = basketSecond.removeProductsByName("Автомобиль BMV X5");
        List<Product> removedToyota = basketSecond.removeProductsByName("Автомобиль Toyota land Cruiser");
        System.out.println(removedBmv + ", " + removedToyota);
        basketSecond.printBasketDetails();
        removedBmv.remove(bmvX5);
        removedToyota.remove(toyotaLandCruiser);
        if (removedBmv.isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            System.out.println(removedBmv);
        }
        if (removedToyota.isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            System.out.println(removedToyota);
        }
        basketSecond.printBasketDetails();


        basketFirst.clearBasket();

        basketFirst.printBasketDetails();

        System.out.println("Поиск товара по имени в пустой корзине = " + basketFirst.checkProductInBasketByName("Картошка"));

    }
}