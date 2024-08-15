package com.javatutorialshub.bookstore.core.feature.update;

import com.google.inject.Inject;
import com.javatutorialshub.bookstore.core.feature.update.port.IUpdateBookPort;
import com.javatutorialshub.bookstore.core.model.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateBookComponent implements IUpdateBookComponent {

    private final IUpdateBookPort updateBookPort;

    @Inject
    public UpdateBookComponent(IUpdateBookPort updateBookPort) {
        this.updateBookPort = updateBookPort;
    }

    @Override
    public Book updateBook(Book book) throws UpdateBookException {
        try {
            return updateBookPort.updateBook(book);
        } catch (Exception e){
            log.warn("Unable to update the book with id starts with: {}, because of {}", book.id(), e.getMessage());
            throw new UpdateBookException(e);
        }
    }
}
