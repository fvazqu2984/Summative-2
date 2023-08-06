package com.company.bookstore.repository;


import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BookRepositoryTest {

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
    public void addBook() {
        //Arrange...
        // Need to create an Author and a Publisher first
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
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostalCode("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);


    }

    @Test
    public void shouldGetBookById() {

        //Arrange...
        // Need to create an Author and a Publisher first
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
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostalCode("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book1 = new Book();
        book1.setIsbn("0-061-96436-0");
        book1.setPublishDate(LocalDate.of(2010, 1, 5));
        book1.setAuthorId(author.getId());
        book1.setTitle("John's Book1");
        book1.setPublisherId(publisher.getId());
        book1.setPrice(new BigDecimal("19.99"));

        book1 = bookRepo.save(book1);

        Book book2 = new Book();
        book2.setIsbn("0-062-95436-0");
        book2.setPublishDate(LocalDate.of(2000, 12, 3));
        book2.setAuthorId(author.getId());
        book2.setTitle("John's Book2");
        book2.setPublisherId(publisher.getId());
        book2.setPrice(new BigDecimal("15.99"));

        book2 = bookRepo.save(book2);

        //Assert...
        Optional<Book> foundAlbum = bookRepo.findById(book1.getId());

        assertEquals(foundAlbum.get(), book1);
    }

    @Test
    public void shouldGetAllBooks() {

        //Arrange...
        // Need to create an Author and a Publisher first
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
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostalCode("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book1");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);

        book = new Book();
        book.setIsbn("0-062-95436-0");
        book.setPublishDate(LocalDate.of(2000, 12, 3));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book2");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("15.99"));

        book = bookRepo.save(book);

        //Assert...
        List<Book> bookList = bookRepo.findAll();

        assertEquals(bookList.size(), 2);
    }

    @Test
    public void shouldUpdateBook() {

        // Need to create an Author and a Publisher first
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
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostalCode("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book1");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);


        book.setTitle("NEW TITLE");
        book.setPublishDate(LocalDate.of(2010, 1, 7));
        book.setPrice(new BigDecimal("15.99"));

        bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getId());
        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldDeleteBookById() {

        //Arrange...
        // Need to create an Author and a Publisher first
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
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostalCode("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        //Act...
        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);

        bookRepo.deleteById(book.getId());

        book1 = bookRepo.findById(book.getId());

        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldGetBooksByAuthorId() {
        // Arrange
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
        publisher.setName("PublisherTM");
        publisher.setStreet("321 Street");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostalCode("54321");
        publisher.setPhone("222-333-4444");
        publisher.setEmail("publisher@gmail.com");
        publisher = publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("0-061-96436-0");
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setAuthorId(author.getId());
        book.setTitle("John's Book");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));
        book = bookRepo.save(book);

        // Act
        List<Book> bookList = bookRepo.findByAuthorId(author.getId());

        // Assert
        assertEquals(1, bookList.size());

    }


}




