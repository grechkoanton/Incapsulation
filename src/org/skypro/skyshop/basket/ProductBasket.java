package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProductToBasket(Product product) {
        products.add(product);
        System.out.println(product);
    }

    public int calculateTotalBasketCost() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        System.out.println("Итоговая сумма из метода calculateTotalBasketCost: " + sum + " руб.");
        return sum;
    }

    public void printBasketDetails() {
        int sum = 0;
        int specialCount = 0;
        for (Product product : products) {
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
        System.out.println("Итого: " + sum + " руб.");
        System.out.println("Специальных товаров: " + specialCount + " шт.");
    }

    public boolean checkProductInBasketByName(String productName) {
        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removeProduct = new LinkedList<>();
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product element = productIterator.next();
            if (element != null && element.getName().equals(name)) {
                removeProduct.add(element);
                productIterator.remove();
            }
        }
        return removeProduct;
    }
}