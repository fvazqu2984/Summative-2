package com.company.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="publisher")
public class Publisher {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisher_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();

    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;

    public Publisher(){}

    // getters and setters
    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisher_id == publisher.publisher_id &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(street, publisher.street) &&
                Objects.equals(city, publisher.city) &&
                Objects.equals(state, publisher.state) &&
                Objects.equals(postal_code, publisher.postal_code) &&
                Objects.equals(phone, publisher.phone) &&
                Objects.equals(email, publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher_id, name, street, city, state, postal_code, phone, email);
    }
}
