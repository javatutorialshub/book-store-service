package com.javatutorialshub.bookstore.core.feature.create.book;

import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.core.validator.ValidationException;

public interface ICreateBookComponent {
    Book createBook(Book book, int count) throws CreateBookException, ValidationException;
}
