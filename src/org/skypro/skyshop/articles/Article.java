package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {

    private final String nameArticle;
    private final String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return "Название статьи: " + nameArticle + ". Текст статьи: " + textArticle;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getNameSearchable() {
        return nameArticle;
    }

    @Override
    public String getSearchTypContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameArticle);
    }
}
