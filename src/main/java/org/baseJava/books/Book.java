package org.baseJava.books;

public class Book {
    public String title;
    public int releaseYear;
    public int pages;
    public Author author;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.author = author;
    }

    public boolean isBig() {
        return pages > 500;
    }

    public boolean matches(String word) {
        String wordIC= word.toLowerCase();
        return title.toLowerCase().contains(wordIC) || author.name.toLowerCase().contains(wordIC) || author.surname.toLowerCase().contains(wordIC);
    }

    public int estimatePrice() {
        int price = (int) (3 * pages * Math.sqrt(author.rating));
        return Math.max (250,price);
    }

}
