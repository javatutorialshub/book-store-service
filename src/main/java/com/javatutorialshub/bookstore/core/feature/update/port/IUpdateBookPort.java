package com.javatutorialshub.bookstore.core.feature.update.port;

import com.javatutorialshub.bookstore.core.feature.update.UpdateBookException;
import com.javatutorialshub.bookstore.core.model.Book;

public interface IUpdateBookPort {

    Book updateBook(Book book) throws UpdateBookException;
}
