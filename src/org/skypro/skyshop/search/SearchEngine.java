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
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                if (count < 5) {
                    results[count++] = searchable;
                } else {
                    break;
                }
            }
        }
        return results;
    }
}

