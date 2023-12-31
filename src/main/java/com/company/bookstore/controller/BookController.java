package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository repo;

    //CreateBook
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    //Get book by id
    @GetMapping("/read/{id}")
    public Book getBookById(@PathVariable int id) {

        Optional<Book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //Get all books
    @GetMapping("/read/all")
    public List<Book> getBooks() {
        return repo.findAll();
    }

    //Update book
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    //Delete book
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

    //Search book by author id
    @GetMapping("/searchByAuthorId/{authorId}")
    public List<Book> getCustomersByAuthorId(@PathVariable int authorId) {
        return repo.findByAuthorId(authorId);
    }
}
