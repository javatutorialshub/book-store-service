package com.javatutorialshub.bookstore.core.feature.find.byid;

import com.javatutorialshub.bookstore.core.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface IFindBookByIdComponent {
    @NotNull
    Book findById(@NotBlank(message = "{findBookById.bookId.message}") String bookId) throws FindBookByIdException;
}
