package com.javatutorialshub.bookstore.infra.feature.create.book.adapter;

import com.javatutorialshub.bookstore.core.feature.create.book.CreateBookException;
import com.javatutorialshub.bookstore.core.feature.create.book.port.ICreateBookPort;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.infra.feature.BookStore;

public class CreateBookAdapter implements ICreateBookPort {
    @Override
    public Book createBook(Book book, int count) throws CreateBookException {
        Book newBook = null;
        for(int p = 0; p < count; p++) {
            newBook = new Book(book.id() + ":" + (p + 1),book.isbn(), book.title(), book.summary(), book.pages(), book.publicationDate(), book.author(), book.owner());
            BookStore.getInstance().add(newBook);
        }
        return newBook;
    }
}
