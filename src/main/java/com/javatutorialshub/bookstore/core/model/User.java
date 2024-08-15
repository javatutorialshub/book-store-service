package com.javatutorialshub.bookstore.core.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record User(
    @NotBlank(message = "{user.name.NotBlank.message}")
    String name,

    @NotBlank(message = "{user.firstName.NotBlank.message}")
    String firstName,

    @NotBlank(message = "{user.email.NotBlank.message}")
    @Email(message = "{user.email.Email.message}")
    String email,

    @NotNull(message = "{user.birthDate.NotNull.message}")
    @Past(message = "{user.birthDate.Past.message}")
    LocalDateTime birthDate
) {
}
