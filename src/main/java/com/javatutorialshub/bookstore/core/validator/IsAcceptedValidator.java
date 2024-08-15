package com.javatutorialshub.bookstore.core.validator;

import com.javatutorialshub.bookstore.core.model.Author;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.stream.Stream;

public class IsAcceptedValidator implements ConstraintValidator<IsAccepted, Author> {
    private String[] value;

    @Override
    public void initialize(IsAccepted constraintAnnotation) {
        value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Author author, ConstraintValidatorContext constraintValidatorContext) {
        return author != null && value != null && Stream.of(value).anyMatch(s -> s.equals(author.country()));
    }
}
