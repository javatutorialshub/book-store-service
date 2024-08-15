package com.javatutorialshub.bookstore.app.handler;

import com.javatutorialshub.bookstore.core.model.ActionType;
import com.javatutorialshub.bookstore.core.model.Author;
import com.javatutorialshub.bookstore.core.model.Book;
import com.javatutorialshub.bookstore.core.model.User;
import jakarta.validation.constraints.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class ApplicationInOutHandler implements InOutHandler {
    protected final InputStream in;
    protected final PrintStream out;
    protected boolean canContinue = true;
    protected Scanner scanner;

    public ApplicationInOutHandler(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(this.in);
    }

    @Override
    public boolean canContinue() {
        return canContinue;
    }

    @Override
    public ActionType requestForActionType() {
        out.println("Which action to proceed (cb: CREATE_BOOK, mb: MODIFY_BOOK, db: DELETE_BOOK, fb: FIND_BOOK) ?");
        String line = scanner.nextLine();
        Optional<ActionType> actionType = Stream.of(ActionType.values()).filter(c -> line.equals(c.getShortWord())).findFirst();
        return actionType.orElse(null);
    }

    @Override
    public User requestForOwner() {
        out.println("---> Provide Information for owner <---");
        out.println("Owner name ?");
        String name = scanner.nextLine();

        out.println("Owner firstName ?");
        String firstName = scanner.nextLine();

        out.println("Owner email ?");
        String email = scanner.nextLine();

        out.println("Owner birth date (yyyy-mm-dd) ?");
        String birth = scanner.nextLine();
        LocalDateTime birthDate = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(birth + " 00:00:01"));

        return new User(name, firstName, email, birthDate);
    }

    @Override
    public Author requestForAuthor() {
        out.println("===> Provide Information for author <===");
        out.println("Author name ?");
        String name = scanner.nextLine();

        out.println("Author firstName ?");
        String firstName = scanner.nextLine();

        out.println("Author alias ?");
        String alias = scanner.nextLine();

        out.println("Author country (US, CA, FR, UK, DE, OTH) ?");
        String country = scanner.nextLine();

        return new Author(name, firstName, alias, country);
    }

    @Override
    public Book requestForBook(User owner, Author author) {
        out.println("===> Provide Information for the book <===");
        out.println("Book isbn ?");
        String isbn = scanner.nextLine();

        out.println("Book title ?");
        String title = scanner.nextLine();

        out.println("Book summary ?");
        String summary = scanner.nextLine();

        out.println("Book pages ?");
        String pagesAsString = scanner.nextLine();
        int pages = Integer.parseInt(pagesAsString);

        out.println("Book publication date ?");
        String pubDate = scanner.nextLine();
        LocalDateTime publicationDate = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(pubDate + " 00:00:01"));

        return new Book(null, isbn, title, summary, pages, publicationDate, author, owner);
    }

    @Override
    public int requestForBookCount() {
        out.println("===> Provide Information for the book count <===");
        out.println("How many books like this to store ?");
        String countAsString = scanner.nextLine();
        return Integer.parseInt(countAsString);
    }

    @Override
    public void showBookId(Book book) {
        out.println("Last Created book ID ->" + book.id());
    }

    @Override
    public void requestForContinue() {
        out.println("Would you want to continue (Y: yes, N: no) ?");
        String line = scanner.nextLine();
        canContinue = "Y".equalsIgnoreCase(line);
    }

    @Override
    public String requestForBookId() {
        out.println("Which Book Id to update ?");
        return scanner.nextLine();
    }
}
