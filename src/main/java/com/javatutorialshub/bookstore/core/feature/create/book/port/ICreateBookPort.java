package com.javatutorialshub.bookstore.core.feature.create.book.port;

import com.javatutorialshub.bookstore.core.feature.create.book.CreateBookException;
import com.javatutorialshub.bookstore.core.model.Book;

public interface ICreateBookPort {
    Book createBook(Book book, int count) throws CreateBookException;
}
