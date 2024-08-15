package org.books;

public class Library {
    public static void askTheLibrarian() {
        Author author = new Author("Daniel", "Keyes", 8);
        Book book = new Book("Flowers for Algernon", 2012, author, 289);
        System.out.println("Большая книга? " + book.isBig());
        System.out.println("'Algernon' входит в название или имя автора? " + book.matches("Algernon"));
        System.out.println("'Keyes' входит в название или имя автора? " + book.matches("Keyes"));
        System.out.println("'Aliona' входит в название или имя автора? " + book.matches("Aliona"));
        System.out.println("стоимость книги(руб.): " + book.estimatePrice());


    }

}

