package org.skypro.skyshop.search;

public interface Searchable {


    String searchTerm();

    String getSearchTypContent();

    String getNameSearchable();

    default String getStringRepresentation() {
        return getNameSearchable() + getSearchTypContent();
    }
}
