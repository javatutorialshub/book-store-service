package com.javatutorialshub.bookstore.core.feature.create.book;

import com.javatutorialshub.bookstore.core.feature.create.book.port.ICreateBookPort;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.core.validator.BaseValidator;
import com.javatutorialshub.bookstore.core.validator.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class CreateBookComponent implements ICreateBookComponent {

    private final ICreateBookPort createBookPort;

    @Override
    public Book createBook(Book book, int count) throws CreateBookException, ValidationException {
        try {
            Book newBook = new Book(UUID.randomUUID().toString(),book.isbn(), book.title(), book.summary(), book.pages(), book.publicationDate(), book.author(), book.owner());
            BaseValidator<Book> baseValidator = new BaseValidator<>();
            baseValidator.validate(newBook);
            return createBookPort.createBook(newBook, count);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e){
            log.warn("Unable to create the book with count: {}, because of {}", count, e.getMessage());
            throw new CreateBookException(e);
        }
    }

}
