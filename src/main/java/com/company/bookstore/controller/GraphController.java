package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphController {
    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public GraphController(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // 1. Get publisher by id: Including books for the publisher and authors for the books
    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        Optional<Publisher> returnPublisher = publisherRepository.findById(id);
        if (returnPublisher.isPresent()) {
            return returnPublisher.get();
        }
        return null;
    }

    // 2. Get an author by id: Including books by the author
    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        Optional<Author> returnAuthor = authorRepository.findById(id);
        if (returnAuthor.isPresent()) {
            return returnAuthor.get();
        }
        return null;
    }

    // 3. Get a book by id: Including the author and publisher of the book
    @QueryMapping
    public Book findBookById(@Argument int id) {
        Optional<Book> returnBook = bookRepository.findById(id);
        if (returnBook.isPresent()) {
            return returnBook.get();
        }
        return null;
    }

    @SchemaMapping
    public Author author(Book book) {
        Optional<Author> returnVal = authorRepository.findById(book.getAuthorId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        }

        return null;
    }

    @SchemaMapping
    public Publisher publisher(Book book) {
        Optional<Publisher> returnVal = publisherRepository.findById(book.getPublisherId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        }

        return null;
    }
}