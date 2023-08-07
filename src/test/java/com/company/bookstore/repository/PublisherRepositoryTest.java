package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PublisherRepositoryTest {
    @Autowired
    PublisherRepository publisherRepository;

    Publisher publisher1;
    Publisher publisher2;

    @BeforeEach
    public void setUp() {
        // 1. delete all records in database
        publisherRepository.deleteAll();

        // 2. initialization of publisher1
        publisher1 = new Publisher();
        publisher1.setPublisher_id(1);
        publisher1.setName("Publisher1");
        publisher1.setStreet("Street 1");
        publisher1.setCity("City 1");
        publisher1.setState("CA");
        publisher1.setPostal_code("12345");
        publisher1.setPhone("123-456-7890");
        publisher1.setEmail("publisher1@example.com");

        // 3. initialization of publisher2
        publisher2 = new Publisher();
        publisher2.setPublisher_id(2);
        publisher2.setName("Publisher2");
        publisher2.setStreet("Street 2");
        publisher2.setCity("City 2");
        publisher2.setState("CA");
        publisher2.setPostal_code("12345");
        publisher2.setPhone("123-456-0000");
        publisher2.setEmail("publisher2@example.com");
    }

    @Test
    public void testSave() {
        // Act...
        publisherRepository.save(publisher1);
        Optional<Publisher> savedPublisher = publisherRepository.findById(publisher1.getPublisher_id());

        // Assert...
        assertTrue(savedPublisher.isPresent());
        assertEquals(publisher1.getPublisher_id(), savedPublisher.get().getPublisher_id());
    }

    @Test
    public void testFindById() {
        // Act...
        publisherRepository.save(publisher1);
        Optional<Publisher> savedPublisher = publisherRepository.findById(publisher1.getPublisher_id());

        // Assert...
        assertTrue(savedPublisher.isPresent());
        assertEquals(publisher1.getPublisher_id(), savedPublisher.get().getPublisher_id());
    }

    @Test
    public void testDelete() {
        // Act...
        publisherRepository.save(publisher1);
        publisherRepository.delete(publisher1);
        Optional<Publisher> deletedPublisher = publisherRepository.findById(publisher1.getPublisher_id());

        // Assert...
        assertTrue(deletedPublisher.isEmpty());
    }

    @Test
    public void testReadAll() {
        // Act...
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);
        List<Publisher> publishers = publisherRepository.findAll();

        // Assert...
        assertThat(publishers)
                .hasSize(2)
                .extracting(Publisher::getName)
                .containsOnly(publisher1.getName(), publisher2.getName());
    }
}
