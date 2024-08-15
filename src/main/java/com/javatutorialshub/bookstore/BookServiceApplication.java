package com.javatutorialshub.bookstore;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.javatutorialshub.bookstore.app.handler.ApplicationInOutHandler;
import com.javatutorialshub.bookstore.app.handler.ApplicationUpdateBookInOutHandler;
import com.javatutorialshub.bookstore.app.handler.InOutHandler;
import com.javatutorialshub.bookstore.app.module.UpdateBookModule;
import com.javatutorialshub.bookstore.core.feature.create.book.CreateBookComponent;
import com.javatutorialshub.bookstore.core.feature.create.book.ICreateBookComponent;
import com.javatutorialshub.bookstore.core.feature.find.byid.IFindBookByIdComponent;
import com.javatutorialshub.bookstore.core.feature.update.IUpdateBookComponent;
import com.javatutorialshub.bookstore.core.model.ActionType;
import com.javatutorialshub.bookstore.core.model.Author;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.core.model.User;
import com.javatutorialshub.bookstore.core.validator.ValidationException;
import com.javatutorialshub.bookstore.infra.feature.create.book.adapter.CreateBookAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookServiceApplication {

    public static void main(String[] args) {
        try {
            InOutHandler inOutHandler = new ApplicationInOutHandler(System.in, System.out);

            while(inOutHandler.canContinue()) {
                ActionType actionType = inOutHandler.requestForActionType();
                switch(actionType){
                    case CREATE_BOOK -> {
                        inOutHandler = new ApplicationInOutHandler(System.in, System.out);

                        User owner = inOutHandler.requestForOwner();
                        Author author = inOutHandler.requestForAuthor();
                        Book book = inOutHandler.requestForBook(owner, author);
                        int count = inOutHandler.requestForBookCount();
                        ICreateBookComponent createBookComponent = new CreateBookComponent(new CreateBookAdapter());
                        // La validation est manuelle par ici
                        Book result = createBookComponent.createBook(book, count);
                        inOutHandler.showBookId(result);
                    }
                    case MODIFY_BOOK -> {
                        ////////////////////////////////////////////////////////////////////////////////////////////////
                        // Utilisation de Guice ici, afin de faire la validation des paramètres de méthode et des valeurs
                        // de retour de manière transparante et comme le préconise Jakarta Bean Validation
                        ////////////////////////////////////////////////////////////////////////////////////////////////
                        Injector injector = Guice.createInjector(new UpdateBookModule());
                        IFindBookByIdComponent findBookByIdComponent = injector.getInstance(IFindBookByIdComponent.class);
                        IUpdateBookComponent updateBookComponent = injector.getInstance(IUpdateBookComponent.class);

                        String existingBookId = inOutHandler.requestForBookId();
                        Book existingBook = findBookByIdComponent.findById(existingBookId);

                        inOutHandler = new ApplicationUpdateBookInOutHandler(System.in, System.out, existingBook);
                        User owner = inOutHandler.requestForOwner();
                        Author author = inOutHandler.requestForAuthor();
                        Book book = inOutHandler.requestForBook(owner, author);


                        Book result = updateBookComponent.updateBook(book);
                        inOutHandler.showBookId(result);

                    }
                    default -> {
                        return;
                    }
                }
                inOutHandler.requestForContinue();
            }
        } catch (ValidationException e) {
            log.warn(e.getMessage());
            e.getFieldConstraints().forEach(c -> {
                log.warn("-> {} : {}", c.field(), c.errorMessage());
            });
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }


    }
}