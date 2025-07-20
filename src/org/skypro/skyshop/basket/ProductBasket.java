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
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        System.out.println("Итоговая сумма из метода calculateTotalBasketCost: " + sum + " руб.");
        return sum;
    }

    public void printBasketDetails() {
        int sum = 0;
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    sum += product.getPrice();
                }
                if (product == null) {
                    System.out.println("Ячейка в корзине пустая.");
                }
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + sum + " руб.");
        System.out.println("Специальных товаров: " + specialCount + " шт.");
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