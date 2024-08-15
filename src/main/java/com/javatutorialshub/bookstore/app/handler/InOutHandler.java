package com.javatutorialshub.bookstore.app.handler;

import com.javatutorialshub.bookstore.core.model.ActionType;
import com.javatutorialshub.bookstore.core.model.Author;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.core.model.User;

public interface InOutHandler {
    boolean canContinue();

    ActionType requestForActionType();

    User requestForOwner();

    Author requestForAuthor();

    Book requestForBook(User owner, Author author);

    int requestForBookCount();

    void showBookId(Book result);

    void requestForContinue();

    String requestForBookId();
}
