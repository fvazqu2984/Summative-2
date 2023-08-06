package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepo;


    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testCreateAuthor() throws Exception {
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

        String json = mapper.writeValueAsString(author);

        mockMvc.perform(post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

    }

    @Test
    public void testGetAuthorById() throws Exception {
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

        mockMvc.perform(get("/authors/{id}", 1))
                .andExpect(status().isOk());


    }

    @Test
    public void testGetAllAuthors() throws Exception {
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



        String json = mapper.writeValueAsString(author);

        mockMvc.perform(get("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAuthor() throws Exception {
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

        String json = mapper.writeValueAsString(author);

        mockMvc.perform(put("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteCustomer() throws Exception {
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

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/customer/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

}
