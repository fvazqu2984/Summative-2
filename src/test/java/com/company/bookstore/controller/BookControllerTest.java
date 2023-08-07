package com.company.bookstore.controller;


import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private PublisherRepository publisherRepo;


    //ObjectMapper mapper = new ObjectMapper();

    ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Test
    public void testCreateBook() throws Exception {
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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(1);
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        String json = mapper.writeValueAsString(book);

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

    }

    @Test
    public void testGetBookById() throws Exception {
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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(1);
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        String json = mapper.writeValueAsString(book);

        mockMvc.perform(get("/books/{id}", 1))
                .andExpect(status().isOk());


    }

    @Test
    public void testGetAllBooks() throws Exception {
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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(1);
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));

        String json = mapper.writeValueAsString(book);

        mockMvc.perform(get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateBook() throws Exception {
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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(1);
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));
        bookRepo.save(book);

        book.setTitle("NEW TITLE");
        book.setPublishDate(LocalDate.of(2010, 1, 7));
        book.setPrice(new BigDecimal("15.99"));
        bookRepo.save(book);

        String json = mapper.writeValueAsString(book);

        mockMvc.perform(put("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteBook() throws Exception {
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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(1);
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));
        bookRepo.save(book);

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/{id}", book.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testGetBookByAuthorId() throws Exception {
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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(1);
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        //book.setId(1);
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("19.99"));
        bookRepo.save(book);

        String json = mapper.writeValueAsString(book);

        List<Book> bookList = Arrays.asList(book);

        mockMvc.perform(get("/booksByAuthorId/{authorId}", author.getId()))
                .andExpect(status().isOk());
    }


}

