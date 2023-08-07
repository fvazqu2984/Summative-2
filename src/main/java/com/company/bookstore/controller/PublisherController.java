package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    // RESTful APIs
    // 1. Create
    @PostMapping("/create")
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // 2. Read by Id
    @GetMapping("/read/{id}")
    public Optional<Publisher> readById(@PathVariable int id) {
        return publisherRepository.findById(id);
    }

    // 3. Read All
    @GetMapping("/read/all")
    public List<Publisher> readAll() {
        return publisherRepository.findAll();
    }

    // 4. Update
    @PutMapping("/update")
    public ResponseEntity<?> updatePublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
        return ResponseEntity.ok("Successfully Updated a Publisher!");
    }

    // 5. Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        publisherRepository.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted a Publisher!");
    }

    // GraphQLs
    // 1. Get publisher by id: Including books for the publisher and authors for the books
    @QueryMapping
    public Optional<Publisher> getPublisherById(@Argument int id) {
        return publisherRepository.findById(id);
    }

    // 2. Get an author by id: Including books by the author

    // 3. Get a book by id: Including the author and publisher of the book
}
