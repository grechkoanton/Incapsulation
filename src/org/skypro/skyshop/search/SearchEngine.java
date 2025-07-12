package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }


    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count++] = searchable;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int counter = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                if (counter < 5) {
                    results[counter++] = searchable;
                } else {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findBestFoundMatch(String search) throws BestResultNotFoundException {
        int maxCount = 0;
        Searchable bestMatch = null;
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
                    bestMatch = searchable;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException("Ошибка! Не нашлось подходящей статьи для: " + search);
        }
        return bestMatch;
    }
}

