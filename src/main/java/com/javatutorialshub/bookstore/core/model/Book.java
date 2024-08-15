package com.javatutorialshub.bookstore.core.model;

import com.javatutorialshub.bookstore.core.validator.IsAccepted;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record Book(
    @NotBlank
    String id,

    @NotBlank
    String isbn,

    @NotBlank
    @Size(min = 5)
    String title,

    @NotBlank
    @Size(max = 100)
    String summary,

    @Min(1)
    int pages,

    @NotNull
    @Past
    LocalDateTime publicationDate,

    @NotNull
    @Valid
    @IsAccepted(value = {"US", "CA", "FR", "UK", "DE"})
    Author author,

    @NotNull
    @Valid
    User owner
) {
}
