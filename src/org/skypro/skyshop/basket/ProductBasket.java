package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProductToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product не может быть null");
        }
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int calculateTotalBasketCost() {
        int total = products.values().stream().flatMap(Collection::stream)
                .mapToInt(x -> x.getPrice())
                .sum();
        System.out.println("Итоговая сумма из метода calculateTotalBasketCost: " + total + " руб.");
        return total;
    }

    public void printBasketDetails() {
        if (products == null) {
            System.out.println("Ячейка в корзине пустая.");
        }
        int specialCount = getSpecialCount();
        products.values().stream().flatMap(Collection::stream).forEach(product -> System.out.println(product));
        int total = products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("Итого: " + total + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }

    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean checkProductInBasketByName(String productName) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.getName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removeProduct = new ArrayList<>();

        for (List<Product> productList : products.values()) {
            Iterator<Product> productIterator = productList.iterator();
            while (productIterator.hasNext()) {
                Product element = productIterator.next();
                if (element != null && element.getName().equals(name)) {
                    removeProduct.add(element);
                    productIterator.remove();
                }
            }
        }
        return removeProduct;
    }
}