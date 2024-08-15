package com.javatutorialshub.bookstore.app.handler;

import com.javatutorialshub.bookstore.core.model.Author;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.core.model.User;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApplicationUpdateBookInOutHandler extends ApplicationInOutHandler {
    private Book existingBook;

    public ApplicationUpdateBookInOutHandler(InputStream in, PrintStream out, Book existingBook) {
        super(in, out);
        this.existingBook = existingBook;
    }

    @Override
    public User requestForOwner() {
        out.println("---> Provide Information for owner <---");
        out.println("Owner name or ENTER to keep: [" + existingBook.owner().name() + "] ?");
        String name = scanner.nextLine();
        name = name.isBlank() ? existingBook.owner().name() : name;

        out.println("Owner firstName or ENTER to keep: [" + existingBook.owner().firstName() + "] ?");
        String firstName = scanner.nextLine();
        firstName = firstName.isBlank() ? existingBook.owner().firstName() : firstName;

        out.println("Owner email or ENTER to keep: [" + existingBook.owner().email() + "] ?");
        String email = scanner.nextLine();
        email = email.isBlank() ? existingBook.owner().email() : email;

        out.println("Owner birth date (yyyy-mm-dd) or ENTER to keep: [" + existingBook.owner().birthDate() + "] ?");
        String birth = scanner.nextLine();
        LocalDateTime birthDate = birth.isBlank() ? existingBook.owner().birthDate() : LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(birth + " 00:00:01"));

        return new User(name, firstName, email, birthDate);
    }

    @Override
    public Author requestForAuthor() {
        out.println("===> Provide Information for author <===");
        out.println("Author name or ENTER to keep: [" + existingBook.author().name() + "] ?");
        String name = scanner.nextLine();
        name = name.isBlank() ? existingBook.author().name() : name;

        out.println("Author firstName or ENTER to keep: [" + existingBook.author().firstName() + "] ?");
        String firstName = scanner.nextLine();
        firstName = firstName.isBlank() ? existingBook.author().firstName() : firstName;

        out.println("Author alias or ENTER to keep: [" + existingBook.author().alias() + "] ?");
        String alias = scanner.nextLine();
        alias = alias.isBlank() ? existingBook.author().alias() : alias;

        out.println("Author country (US, CA, FR, UK, DE, OTH) or ENTER to keep: [" + existingBook.author().country() + "] ?");
        String country = scanner.nextLine();
        country = country.isBlank() ? existingBook.author().country() : country;

        return new Author(name, firstName, alias, country);
    }

    @Override
    public Book requestForBook(User owner, Author author) {
        out.println("===> Provide Information for the book <===");
        out.println("Book isbn or ENTER to keep: [" + existingBook.isbn() + "] ?");
        String isbn = scanner.nextLine();
        isbn = isbn.isBlank() ? existingBook.isbn() : isbn;

        out.println("Book title or ENTER to keep: [" + existingBook.title() + "] ?");
        String title = scanner.nextLine();
        title = title.isBlank() ? existingBook.title() : title;

        out.println("Book summary or ENTER to keep: [" + existingBook.summary() + "] ?");
        String summary = scanner.nextLine();
        summary = summary.isBlank() ? existingBook.summary() : summary;

        out.println("Book pages or ENTER to keep: [" + existingBook.pages() + "] ?");
        String pagesAsString = scanner.nextLine();
        int pages = pagesAsString.isBlank() ? existingBook.pages() : Integer.parseInt(pagesAsString);

        out.println("Book publication date or ENTER to keep: [" + existingBook.publicationDate() + "] ?");
        String pubDate = scanner.nextLine();
        LocalDateTime publicationDate = pubDate.isBlank() ? existingBook.publicationDate() : LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(pubDate + " 00:00:01"));

        int lastPos = existingBook.id().lastIndexOf(':');
        return new Book(existingBook.id().substring(0, lastPos), isbn, title, summary, pages, publicationDate, author, owner);
    }
}
