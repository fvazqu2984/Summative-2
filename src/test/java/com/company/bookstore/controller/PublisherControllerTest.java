package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublisherController.class)
class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository publisherRepository;

    private Publisher publisher;

    @BeforeEach
    public void setup() {
        publisher = new Publisher();
        // TODO - unnecessary? remove?
//        publisher.setPublisher_id(1);
//        publisher.setName("Publisher1");
//        publisher.setStreet("Street 1");
//        publisher.setCity("City 1");
//        publisher.setState("State 1");
//        publisher.setPostal_code("12345");
//        publisher.setPhone("123-456-7890");
//        publisher.setEmail("publisher1@example.com");
    }

    @Test
    void testCreatePublisher() throws Exception {
        // TODO - Mockito + mockMvc
        when(publisherRepository.save(any(Publisher.class))).thenReturn(publisher);

        mockMvc.perform(post("/publisher/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(publisher)))
                .andExpect(status().isOk());

        verify(publisherRepository, times(1)).save(any(Publisher.class));
    }

    @Test
    void testReadById() throws Exception {
        when(publisherRepository.findById(anyInt())).thenReturn(Optional.of(publisher));

        mockMvc.perform(get("/publisher/read/{id}", 1))
                .andExpect(status().isOk());

        verify(publisherRepository, times(1)).findById(anyInt());
    }

    @Test
    void testReadAll() throws Exception {
        when(publisherRepository.findAll()).thenReturn(List.of(publisher));

        mockMvc.perform(get("/publisher/read/all"))
                .andExpect(status().isOk());

        verify(publisherRepository, times(1)).findAll();
    }

    @Test
    void testUpdatePublisher() throws Exception {
        when(publisherRepository.save(any(Publisher.class))).thenReturn(publisher);

        mockMvc.perform(put("/publisher/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(publisher)))
                .andExpect(status().isOk());

        verify(publisherRepository, times(1)).save(any(Publisher.class));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(publisherRepository).deleteById(anyInt());

        mockMvc.perform(delete("/publisher/delete/{id}", 1))
                .andExpect(status().isOk());

        verify(publisherRepository, times(1)).deleteById(anyInt());
    }
}