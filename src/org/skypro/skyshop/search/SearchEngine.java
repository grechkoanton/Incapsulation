package org.skypro.skyshop.search;

import java.util.*;


public class SearchEngine {

    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void addSearchable(Searchable searchable) {
            searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                    results.add(searchable);
            }
        }
        return results;
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

