package com.javatutorialshub.bookstore.core.model;

import jakarta.validation.constraints.NotBlank;

public record Author(
        @NotBlank
        String name,

        @NotBlank
        String firstName,

        @NotBlank
        String alias,

        @NotBlank
        String country) {
}
