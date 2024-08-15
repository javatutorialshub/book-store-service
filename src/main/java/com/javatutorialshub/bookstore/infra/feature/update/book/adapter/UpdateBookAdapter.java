package com.javatutorialshub.bookstore.infra.feature.update.book.adapter;

import com.javatutorialshub.bookstore.core.feature.update.UpdateBookException;
import com.javatutorialshub.bookstore.core.feature.update.port.IUpdateBookPort;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.infra.feature.BookStore;

import java.util.Collection;

public class UpdateBookAdapter implements IUpdateBookPort {

    @Override
    public Book updateBook(Book book) throws UpdateBookException {
        Collection<String> ids = BookStore.getInstance().getBooIdsStartingWith(book.id());
        Book newBook = null;
        for(String id : ids){
            newBook = new Book(id,book.isbn(), book.title(), book.summary(), book.pages(), book.publicationDate(), book.author(), book.owner());
            BookStore.getInstance().set(id, newBook);
        }
        return newBook;
    }
}
