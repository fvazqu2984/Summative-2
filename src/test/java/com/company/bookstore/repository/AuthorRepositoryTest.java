package com.company.bookstore.repository;


import com.company.bookstore.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @BeforeEach
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
        publisherRepo.deleteAll();

    }

    @Test
    public void shouldAddAuthor() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setStreet("123 Street");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("444-555-6666");
        author.setEmail("jsmith@gmail.com");
        author = authorRepo.save(author);

        //Act...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        //Assert...
        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldGetAuthorById() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setStreet("123 Street");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("444-555-6666");
        author.setEmail("jsmith@gmail.com");
        author = authorRepo.save(author);

        Author author2 = new Author();
        author2.setFirstName("Jane");
        author2.setLastName("Doe");
        author2.setStreet("123 Street");
        author2.setCity("Austin");
        author2.setState("TX");
        author2.setPostalCode("54321");
        author2.setPhone("333-444-6666");
        author2.setEmail("jdoe@gmail.com");
        author2 = authorRepo.save(author2);

        //Act...
        Optional<Author> foundAuthor = authorRepo.findById(author.getId());

        //Assert...
        assertEquals(foundAuthor.get(), author);
    }

    @Test
    public void shouldGetAllAuthors() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setStreet("123 Street");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("444-555-6666");
        author.setEmail("jsmith@gmail.com");
        author = authorRepo.save(author);

        author = new Author();
        author.setFirstName("Jane");
        author.setLastName("Doe");
        author.setStreet("123 Street");
        author.setCity("Austin");
        author.setState("TX");
        author.setPostalCode("54321");
        author.setPhone("333-444-6666");
        author.setEmail("jdoe@gmail.com");
        author = authorRepo.save(author);

        //Act...
        List<Author> authorList = authorRepo.findAll();

        //Assert...
        assertEquals(authorList.size(), 2);
    }

    @Test
    public void shouldUpdateAuthor() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setStreet("123 Street");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("444-555-6666");
        author.setEmail("jsmith@gmail.com");
        author = authorRepo.save(author);

        author = new Author();
        author.setFirstName("Jane");
        author.setLastName("Doe");
        author.setStreet("123 Street");
        author.setCity("Austin");
        author.setState("TX");
        author.setPostalCode("54321");
        author.setPhone("333-444-6666");
        author.setEmail("jdoe@gmail.com");
        author = authorRepo.save(author);

        //Act...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        //Assert...
        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldDeleteAuthorById() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setStreet("123 Street");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("444-555-6666");
        author.setEmail("jsmith@gmail.com");
        author = authorRepo.save(author);

        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);

        //Act...
        authorRepo.deleteById(author.getId());

        author1 = authorRepo.findById(author.getId());

        //Assert...
        assertFalse(author1.isPresent());
    }




}
