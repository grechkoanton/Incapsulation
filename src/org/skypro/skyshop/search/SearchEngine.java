package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.List;


public class SearchEngine {

    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public void addSearchable(Searchable searchable) {
            searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                    results.add(searchable);
            }
        }
        return results;
    }

    public List<Searchable> findBestFoundMatch(String search) throws BestResultNotFoundException {
        int maxCount = 0;
        List<Searchable> bestMatch = null;
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

