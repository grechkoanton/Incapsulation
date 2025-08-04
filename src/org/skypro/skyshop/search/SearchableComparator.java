package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        System.out.println("Сравниваем товары: " + o1.getNameSearchable() + " и " + o2.getNameSearchable());
        int lenghtCompare = Integer.compare(o1.getNameSearchable().length(), o2.getNameSearchable().length());
        if (lenghtCompare != 0) {
            System.out.println("Результат сравнения по длине имени: " + lenghtCompare);
            return lenghtCompare;
        }
        int result = o1.getNameSearchable().compareTo(o2.getNameSearchable());
        System.out.println("Результат сравнения по имени: " + result);
        return result;
    }
}