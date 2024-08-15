package com.javatutorialshub.bookstore.infra.feature;

import com.javatutorialshub.bookstore.core.model.Book;

import java.util.*;

public class BookStore {
    private static BookStore bookStore;
    private final Map<String, Book> bookMap;

    private BookStore(){
        bookMap = new HashMap<>();
    }

    public static BookStore getInstance() {
        if(bookStore == null){
            bookStore = new BookStore();
        }
        return bookStore;
    }

    public void add(Book book) {
        bookMap.put(book.id(), book);
    }

    public Book getOneBookWithIdStartingBy(String bookId) {
        Optional<Map.Entry<String, Book>> opt = bookMap.entrySet().stream().filter(entry -> entry.getKey().startsWith(bookId)).findFirst();
        return opt.map(Map.Entry::getValue).orElse(null);
    }

    public void set(String id, Book book) {
        bookMap.put(id, book);
    }

    public Collection<String> getBooIdsStartingWith(String bookId) {
        return bookMap.keySet().stream().filter(book -> book.startsWith(bookId)).toList();
    }
}
