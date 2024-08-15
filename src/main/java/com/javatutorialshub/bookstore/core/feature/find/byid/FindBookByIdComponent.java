package com.javatutorialshub.bookstore.core.feature.find.byid;

import com.google.inject.Inject;
import com.javatutorialshub.bookstore.core.feature.find.byid.port.IFindBookByIdPort;
import com.javatutorialshub.bookstore.core.model.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindBookByIdComponent implements IFindBookByIdComponent {

    private final IFindBookByIdPort findBookByIdPort;

    @Inject
    public FindBookByIdComponent(IFindBookByIdPort findBookByIdPort) {
        this.findBookByIdPort = findBookByIdPort;
    }

    @Override
    public Book findById(String bookId) throws FindBookByIdException {
        try {
            return findBookByIdPort.findById(bookId);
        } catch (Exception e){
            log.warn("Unable to the book with id: {}, because of {}", bookId, e.getMessage());
            throw new FindBookByIdException(e);
        }
    }
}
