package com.sfeir.kata.bankkata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue
    public Long clientId;
    @Column(nullable = false)
    public String lastname;
    @Column(nullable = false)
    public String firstname;
    @Column(nullable = false)
    public LocalDate birthdate;

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    public String address;

    public Client(ClientBuilder builder) {
        this.lastname = builder.lastname;
        this.firstname = builder.firstname;
        this.birthdate = builder.birthdate;
        this.address = builder.address;

    }

    public static class ClientBuilder{

        // Required
        private final String lastname;
        private final String firstname;
        private final LocalDate birthdate;
        private String address;

        public ClientBuilder(String lastname, String firstname, LocalDate birthdate) {
            this.lastname = lastname;
            this.firstname = firstname;
            this.birthdate = birthdate;

        }

        public ClientBuilder setAddress(String address) {
            this.address = address;
            return this;
        }


    }

}
