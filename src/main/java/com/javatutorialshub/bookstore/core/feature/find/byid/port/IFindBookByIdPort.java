package com.javatutorialshub.bookstore.core.feature.find.byid.port;

import com.javatutorialshub.bookstore.core.model.Book;

public interface IFindBookByIdPort {
    Book findById(String bookId);
}
