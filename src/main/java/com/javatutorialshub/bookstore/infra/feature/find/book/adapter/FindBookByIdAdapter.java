package com.javatutorialshub.bookstore.infra.feature.find.book.adapter;

import com.javatutorialshub.bookstore.core.feature.find.byid.port.IFindBookByIdPort;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.infra.feature.BookStore;

public class FindBookByIdAdapter implements IFindBookByIdPort {
    @Override
    public Book findById(String bookId) {
        return BookStore.getInstance().getOneBookWithIdStartingBy(bookId);
    }
}
