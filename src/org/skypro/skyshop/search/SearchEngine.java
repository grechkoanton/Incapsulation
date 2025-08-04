package org.skypro.skyshop.search;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;


public class SearchEngine {

    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void addSearchable(Searchable searchable) {
            searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(obj -> obj.searchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public Set<Searchable> findBestFoundMatch(String search) throws BestResultNotFoundException {
        int maxCount = 0;
        Set<Searchable> bestMatch = null;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String term = searchable.searchTerm();
                int currentCount = 0;
                int index = term.indexOf(search);
                while (index != -1) {
                    currentCount++;
                    index = term.indexOf(search, index + search.length());
                }
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    bestMatch = searchables;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException("Ошибка! Не нашлось подходящей статьи для: " + search);
        }
        return bestMatch;
    }
}

