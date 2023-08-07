package com.company.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {
    // fields
    @Id
    private int publisher_id;

    // TODO - set cascade
//    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Book> books;

    // TODO - in book class
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "publisher_id")
//    private Publisher publisher;

    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;

    // getters and setters
    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
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
}
