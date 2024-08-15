package com.javatutorialshub.bookstore.core.model;

import lombok.Getter;

@Getter
public enum ActionType {
    CREATE_BOOK("cb"), MODIFY_BOOK("mb"), DELETE_BOOK("db"), FIND_BOOK("fb");

    final String shortWord;

    ActionType(String shortWord) {
        this.shortWord = shortWord;
    }
}
