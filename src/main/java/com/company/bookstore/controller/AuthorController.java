package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository repo;

    //Create author
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    //Get author by id
    @GetMapping("/read/{id}")
    public Author getAuthorById(@PathVariable int id) {

        Optional<Author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //Get all authors
    @GetMapping("/read/all")
    public List<Author> getAuthors() {
        return repo.findAll();
    }

    //Update book
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {
        repo.save(author);
    }

    //Delete book
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }
}
