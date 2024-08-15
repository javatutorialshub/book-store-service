package com.javatutorialshub.bookstore.core.feature.update;

import com.javatutorialshub.bookstore.core.model.Book;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface IUpdateBookComponent {
    @NotNull
    Book updateBook(@Valid @NotNull Book book) throws UpdateBookException;
}
